package com.lyl.technology.jvm.createAndDestroyObject;

/**
 * Created by lyl
 * Date 2019/12/19 20:36
 * VM: -verbose: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class PretenureSizeThreshold {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[6*_1MB];
    }
}
