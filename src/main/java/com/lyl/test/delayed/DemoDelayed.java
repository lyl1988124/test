package com.lyl.test.delayed;

import com.lyl.test.MyDelayed;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DemoDelayed {

    public static void main(String[] args) throws InterruptedException {


        DelayQueue<DemoDelayed.TestDelayed> queue = new DelayQueue<>();
        queue.put(new TestDelayed());
        while (!queue.isEmpty()) {
            //只有到期的数据才能取的出来，否则就阻塞等待
            System.out.println(queue.take());
        }
    }

    private static class TestDelayed implements Delayed{

        @Override
        public long getDelay(TimeUnit unit) {
            System.out.println(3000-System.currentTimeMillis());
            return unit.convert(3000-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            System.out.println("this"+this.getDelay(TimeUnit.MILLISECONDS));
            System.out.println(o.getDelay(TimeUnit.MILLISECONDS));
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}
