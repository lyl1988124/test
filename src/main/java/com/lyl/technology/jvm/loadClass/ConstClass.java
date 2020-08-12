package com.lyl.technology.jvm.loadClass;

/**
 * Created by lyl
 * Date 2019/12/27 20:00
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }
    public static final String HELLOWORLD="hello word";
}
