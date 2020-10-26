package com.lyl.test;

import java.time.Clock;
import java.time.Instant;

import static java.lang.Thread.sleep;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : TesyTemp.java
 *
 * @author : liuyuanlong
 * @date : 2020/6/4 17:03
 */
public class TestThreadDeanm {
    public static void main(String[] args) {

        System.out.println("main start");

        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("sub start");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub end");
            }
        });

        // true or false
        t.setDaemon(true);
        t.start();

        System.out.println("main stop");

        System.out.println(Clock.systemUTC().millis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now());

    }
}
