package com.lyl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lyl
 * @Package com.lyl.test
 * @Title: ThreadPoolTest
 * @Description:
 * @date 2020/11/10 20:51
 */
public class ThreadPoolTest {

    ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(
            2,
            2,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1));

    boolean isFinal = false;

    private void method1(AtomicInteger cnt) {
        while (!isFinal) {
            System.out.println("method1 not final cnt=" + cnt);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cnt.get() <= 0) {
                isFinal = true;
            }
            cnt.getAndDecrement();
        }
    }

    List aa = new ArrayList();

    private void method2(AtomicInteger cnt) {
        while (!isFinal) {
            System.out.println("method2 not final cnt=" + cnt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cnt.get() <= 0) {
                System.out.println(aa.get(100));
                break;
            }
            cnt.getAndDecrement();
        }
    }

    private void start(AtomicInteger param) {
        threadPoolExecutor.submit(()->method1(param));
        threadPoolExecutor.submit(()->method2(param));

        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.start(new AtomicInteger(3));
    }
}
