package com.lyl.test;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : TestTemp.java
 *
 * @author : liuyuanlong
 * @date : 2020/8/14 9:15
 */
public class Test_6 {

    public static void main(String[] args) {
        Test_6_A obj = Test_6_A.getInstance();
        System.out.println(Test_6_A.val1);
        System.out.println(Test_6_A.val2);
    }
}

class Test_6_A {
    public static int val1;
    public static int val2 = 100;
    public static Test_6_A instance = new Test_6_A();

    public Test_6_A() {
        val1++;
        val2++;
    }

    public static Test_6_A getInstance() {
        return instance;
    }
}
