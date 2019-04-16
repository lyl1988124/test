package com.lyl.zookeeper.zkBookExplain;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Date;

/**
 * Created by lyl
 * Date 2019/4/15 20:19
 */
public class AdminClient implements Watcher {
    ZooKeeper zk;

    String hostPort;

    public AdminClient(String hostPort) {
        this.hostPort = hostPort;
    }

    void start(){
        try {
            zk = new ZooKeeper(hostPort,15000,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void listState(){
        try {
            Stat stat = new Stat();
            byte masterData[] = zk.getData("/master",false,stat);
            Date startDate = new Date(stat.getCtime());
            System.out.println("Master: "+new String(masterData) + " since "+ startDate);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Workers: ");
        try {
            for(String w : zk.getChildren("/workers",false)){
                byte data[] = zk.getData("/workers/"+ w,false,null);
                String state = new String(data);
                System.out.println("\t" + w +": "+ state);
            }
            System.out.println("Tasks: ");

//            for(String t: zk.getChildren("",false)){
//                System.out.println("\t" + t);
//            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) {
        AdminClient c = new AdminClient("127.0.0.1:2181");
        c.start();
        c.listState();
    }
}
