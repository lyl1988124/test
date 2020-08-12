package com.lyl.serve.zookeeper.zkBookExplain;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * Created by lyl
 * Date 2019/4/15 19:53
 */
public class Client implements Watcher {

    ZooKeeper zk;
    String hostPort;

    public Client(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK(){
        try {
            zk = new ZooKeeper(hostPort,15000,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String queueCommand(String comand){
        while(true){
            String name = null;
            try {
                name = zk.create("/tasks/tasks-",
                        comand.getBytes(),
                        OPEN_ACL_UNSAFE,
                        CreateMode.EPHEMERAL_SEQUENTIAL);
                return name;
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }


    public static void main(String[] args) {
        Client c= new Client("127.0.0.1:2181");
        c.startZK();
        String serverId = Long.toString(new Random().nextLong());
        String name = c.queueCommand(serverId);
        System.out.println("create"+name);

    }
}
