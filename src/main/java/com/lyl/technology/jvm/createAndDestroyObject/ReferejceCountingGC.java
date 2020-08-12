package com.lyl.technology.jvm.createAndDestroyObject;

/**
 * Created by lyl
 * Date 2019/12/14 15:24
 */
public class ReferejceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

//    public static void testGC(){
public static void main(String[] args) {
        ReferejceCountingGC objA = new ReferejceCountingGC();
        ReferejceCountingGC objB = new ReferejceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();

    }
}
