package com.lyl.test;

import org.apache.commons.lang3.RandomUtils;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : TestWhile.java
 *
 * @author : liuyuanlong
 * @date : 2020/10/22 13:29
 */
public class TestWhile {

    private Boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        TestWhile testWhile = new TestWhile();
        int retry = 10;

        while (!testWhile.getFlag() && retry > 0) {
            retry--;
            System.out.println("retry===>" + retry);
            doSomething(testWhile);
            System.out.println(testWhile.getFlag());
            Thread.sleep(1 * 1000);
        }
    }

    public static void doSomething(TestWhile testWhile) {
        testWhile.setFlag(RandomUtils.nextInt() > RandomUtils.nextInt());

    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
