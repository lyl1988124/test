package com.lyl.thread;

/**
 * Created by lyl on 2017/9/8.
 */
public class ThreadDemo4 {
    public static void main(String[] args){
        Ticket4 t =new Ticket4();
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
class Ticket4 implements Runnable{
    private int ticket = 4000;
    public synchronized void  saleTicket(){
        if(ticket>0)
            System.out.println(Thread.currentThread().getName()+"卖出了"+ticket--);

    }
    public void run(){
        while(true){
            saleTicket();
        }
    }
}
