package com.lyl.zookeeper.zkBookExplain;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by lyl
 * Date 2019/8/15 20:02
 */
public class AuthSample_Get2 {
    final static String PATH = "/zk-book-auth_test";

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper1 = new ZooKeeper("127.0.0.1:2181",5000,null);
        zooKeeper1.addAuthInfo("digest","lyl".getBytes());
        zooKeeper1.create(PATH,"init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);


//        ZooKeeper zooKeeper2 = new ZooKeeper("127.0.0.1:2181",5000,null);
//        zooKeeper2.addAuthInfo("aaa","ly2".getBytes());
//        System.out.println(zooKeeper2.getData(PATH,false,null));

    }
}
