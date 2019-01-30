package com.amber.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 等待其他线程全部执行完毕后，再执行
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i ++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "--------------------------close-----");
    }
}


