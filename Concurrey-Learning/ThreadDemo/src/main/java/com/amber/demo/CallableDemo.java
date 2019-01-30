package com.amber.demo;

import org.apache.tomcat.util.collections.SynchronizedQueue;

public class ThreadYeild {

    public static void main(String[] args) {
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
            super.run();
            for(int i = 0; i < 500; i ++) {
                System.out.println( getName() + "---" + i);
            }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 500; i ++) {

                    System.out.println(getName() + "---" + i);
                }
            }
        };
        //设置最大的线程优先级最大为10
        thread1.setPriority(Thread.MIN_PRIORITY);
        //设置最小的线程优先级，最小为１
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
