package com.lyl.test;

/**
 
 * <p> Description : DeadLockTest
 *
 * @author : liuyuanlong
 * @date : 2022/5/27 17:47
 */
public class DeadLockTest {

    public static Object lock1 = new Object(); //获取笔记本电脑
    public static Object lock2 = new Object(); //获取投影仪

    public static void main(String[] args) {
        new Aobing().start();
        new Xiaomei().start();
    }

    private static class Aobing extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Aobing获取到笔记本电脑");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Aobing被中断了！");
                }
                System.out.println("Aobing正在等待投影仪");
                synchronized (lock2) {
                    System.out.println("Aobing获取到投影仪");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Aobing被中断了");
                    }
                }
                System.out.println("Aobing释放投影仪");
            }
            System.out.println("Aobing释放笔记本电脑");
        }
    }

    private static class Xiaomei extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Xiaomei获取到投影仪");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Xiaomei被中断了！");
                }
                System.out.println("Xiaomei正在等待笔记本电脑");
                synchronized (lock1) {
                    System.out.println("Xiaomei获取到笔记本电脑");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Xiaomei被中断了！");
                    }
                }
                System.out.println("Xiaomei释放笔记本电脑");
            }
            System.out.println("Xiaomei释放投影仪");
        }
    }

}
