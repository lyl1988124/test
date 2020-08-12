package com.lyl.technology.jvm.loadClass;

/**
 * Created by lyl
 * Date 2019/12/27 19:56
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init ");
    }

    public static int value=123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SuperClass SubClass ");
    }
}