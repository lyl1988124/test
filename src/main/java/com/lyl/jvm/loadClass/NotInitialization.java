package com.lyl.jvm.loadClass;


/**
 * Created by lyl
 * Date 2019/12/27 19:58
 */
public class NotInitialization {
    public static void main(String[] args) {
        //System.out.println(SubClass.value);
        //SuperClass[] sca = new SubClass[10];
        System.out.println(ConstClass.HELLOWORLD);
    }
}
