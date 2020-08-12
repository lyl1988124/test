package com.lyl.serve.zookeeper.zkBookExplain;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * Created by lyl
 * Date 2019/4/8 17:43
 */
public class Master implements Watcher {
     ZooKeeper zk;
     String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK(){
        try {
            zk = new ZooKeeper(hostPort,15000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void stopZK(){
        if(zk!=null){
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    String serverId = Integer.toHexString(new Random().nextInt());

    void runForMaster2(){
        try {
            zk.create("/lyl",
                    serverId.getBytes(),
                    OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //String serverId = Long.toString(new Random().nextLong());
    boolean isLeader = false;

    boolean checkMaster(){
        while (true){
            Stat stat = new Stat();
            byte[] data = new byte[0];
            try {
                data = zk.getData("/master",isLeader,stat);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isLeader = new String(data).equals(serverId);
            return true;
        }
    }

    void runForMaster(){
        while (true){
            try {
                zk.create("/master",serverId.getBytes(),OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
                isLeader = true;
                break;
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (checkMaster()){
                break;
            }
        }


    }


    //call back
    AsyncCallback.StringCallback masterCreateCallBack = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)){
                case CONNECTIONLOSS:
                    checkMaster();
                    return;
                case OK:
                    isLeader = true;
                    break;

                default:
                    isLeader = false;

            }
            System.out.println("I am "+ (isLeader? "":"not")+" the leader");
        }
    };

    void runForMaster3() {
        zk.create("/master", serverId.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,masterCreateCallBack,null);
    }

    //初始化
    public void boostrap(){
        createParent("/workers",new byte[0]);
        createParent("/assign",new byte[0]);
        createParent("/tasks",new byte[0]);
        createParent("/status",new byte[0]);
    }

    void createParent(String path, byte[] data){
        zk.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT,createParentCallback,data);
    }

    AsyncCallback.StringCallback createParentCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)){
                case CONNECTIONLOSS:
                    createParent(path, (byte[]) ctx);
                    break;
                case OK:
                    System.out.println("Parent created");
                    break;
                case NODEEXISTS:
                    System.out.println("Parent already");
                    break;
                default:
                    System.out.println("something is wrong");
                    KeeperException.create(KeeperException.Code.get(rc));
            }
        }
    };


    public static void main(String[] args) {
        //Master m = new Master("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");
        Master m = new Master("127.0.0.1:2183");
        m.startZK();
        m.runForMaster3();
        //m.boostrap();
        //m.runForMaster2();
        if (m.isLeader){
            System.out.println("I am master");
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.stopZK();
        //zk.getData("/testRootPath",false,null))
    }
}
