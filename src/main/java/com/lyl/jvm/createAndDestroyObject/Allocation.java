package com.lyl.jvm.createAndDestroyObject;

/**
 * Created by lyl
 * Date 2019/12/18 21:47
 * -verbose: -Xms20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class Allocation {
    private static final int  _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allcation1,allcation2,allcation3,allcation4;
        allcation1 = new byte[2 * _1MB];
        allcation2 = new byte[2 * _1MB];
        allcation3 = new byte[2 * _1MB];
        allcation4 = new byte[4 * _1MB];
    }
}
