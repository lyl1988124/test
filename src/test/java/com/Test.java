package com;

/**
 * Created by lyl on 2017/7/1.
 */
public class Test {
    public static void main(String[] args) {
        for(String a : args){
            System.out.println(a);
        }

        System.out.println(System.getProperty("parallelism"));
    }
}
