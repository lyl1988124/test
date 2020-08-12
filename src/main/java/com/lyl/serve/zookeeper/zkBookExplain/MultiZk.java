package com.lyl.serve.zookeeper.zkBookExplain;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Op;
import org.apache.zookeeper.OpResult;
import org.apache.zookeeper.ZooKeeper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lyl
 * Date 2019/5/7 20:20
 */
public class MultiZk {
    ZooKeeper zk;

    Op deleteZnode(String z){
        return Op.delete(z,-1);
    }

    List<OpResult> results;

    {
        try {
            results = zk.multi(Arrays.asList(deleteZnode(""),deleteZnode("")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
