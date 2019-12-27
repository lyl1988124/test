package com.lyl.jvm.createAndDestroyObject;

/**
 * Created by lyl
 * Date 2019/12/18 21:47
 * -verbose: -Xms20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * idea+jdk1.8默认使用的是Parallel Scavenge回收器，而书上使用的是Serial/Serial Old，所以要想达到和书上一样的结果，要添加条件：-XX:+UseSerialGC
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
