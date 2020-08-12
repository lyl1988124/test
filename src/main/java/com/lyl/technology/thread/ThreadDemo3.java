package com.lyl.technology.thread;

/**
 * Created by lyl on 2017/9/8.
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Ticket t =new Ticket();
        Thread t1 = new Thread(t,"窗口一");
        Thread t2 = new Thread(t,"窗口二");
        Thread t3 = new Thread(t,"窗口三");
        Thread t4 = new Thread(t,"窗口四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Ticket implements Runnable{
    private int ticket=400;
    public void run() {
       while (true){
           synchronized (new Object()){
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               if(ticket<0)
                   break;
               System.out.println(Thread.currentThread().getName()+"---卖出"+ticket--);
           }
       }
    }
}