package com.lyl.zookeeper.zkBookExplain;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Random;

/**
 * Created by lyl
 * Date 2019/4/9 15:47
 */
public class Worker implements Watcher {
    ZooKeeper zk;
    String hostPort;
    String serverId = Integer.toHexString(new Random().nextInt());

    public Worker(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK(){
        try {
            zk = new ZooKeeper(hostPort,15000,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent.toString()+" , "+hostPort);
    }

    void register(){
        zk.create("/workers/worker-"+serverId,
                "Ideal".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                createWorkerCallBack,
                null);
    }

    AsyncCallback.StringCallback createWorkerCallBack = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)){
                case CONNECTIONLOSS:
                    System.out.println("KeeperException.Code.get(rc)");
                    register();
                    break;
                case OK:
                    System.out.println("SUCCESS");
                    break;
                default:
                    System.out.println("wrong" + KeeperException.create(KeeperException.Code.get(rc),path));
            }
        }
    };

    public static void main(String[] args) {
        Worker worker = new Worker("127.0.0.1:2181");
        worker.startZK();
        worker.register();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            worker.zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
