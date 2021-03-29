package com.lyl.test;

import java.util.concurrent.*;

public class FutureTest {

    private static final ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(
            5,
            5,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1)
        );

    private static void methodOne(){
        while (true){
            System.out.println("this is method one.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void methodTwo(){
        while (true){
            System.out.println("this is method two.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Future futureOne = threadPoolExecutor.submit(() -> methodOne());
        Future futureTwo = threadPoolExecutor.submit(() -> methodTwo());

        try {
            futureOne.get();
            futureTwo.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
