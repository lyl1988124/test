package com.lyl.technology.jvm.bytecodeEngine;

/**
 * Created by lyl
 * Date 2020/1/7 20:55
 */
public class OverLoad {
//    public static void sayHello(Object obj){
//        System.out.println("hello Object");
//    }

//    public static void sayHello(int obj){
//        System.out.println("hello int");
//    }

//    public static void sayHello(long obj){
//        System.out.println("hello long");
//    }

//    public static void sayHello(Character obj){
//        System.out.println("hello Character");
//    }

//    public static void sayHello(char obj){
//        System.out.println("hello char");
//    }

    public static void sayHello(char... obj){
        System.out.println("hello char ...");
    }

//    public static void sayHello(Serializable obj){
//        System.out.println("hello Serializable ...");
//    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
