package com.lyl.test;

/**
 
 * <p> Description : DeadLockTest2
 *
 * @author : liuyuanlong
 * @date : 2022/5/27 17:54
 */
public class DeadLockTest2 {

    public static Object lock1 = new Object();  //获取笔记本电脑
    public static Object lock2 = new Object();  //获取投影仪

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
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

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Xiaomei获取到笔记本电脑");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Xiaomei被中断了！");
                }
                System.out.println("Xiaomei正在等待投影仪");
                synchronized (lock2){
                    System.out.println("Xiaomei获取到了投影仪");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Xiaomei被中断了！");
                    }
                }
                System.out.println("Xiaomei释放投影仪");
            }
            System.out.println("Xiaomei释放笔记本电脑");
        }
    }
}
