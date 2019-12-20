package com.lyl.jvm.createAndDestroyObject;

/**
 * Created by lyl
 * Date 2019/12/19 20:46
 * VM: -verbose: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 */
public class TenuringThreshold {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[_1MB/4];
        allocation4 = new byte[_1MB/4];

        allocation2 = new byte[4*_1MB];

        allocation3 = new byte[4*_1MB];

        allocation3=null;
        allocation3 = new byte[4*_1MB];
    }
}
