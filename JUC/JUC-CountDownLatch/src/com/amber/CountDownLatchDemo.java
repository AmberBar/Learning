package com.amber;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        long start = System.currentTimeMillis();




        for (int i = 0 ; i < 5 ; i ++) {
            new MyThread(countDownLatch).start();
        }

        try {
            countDownLatch.await();
        } catch (Exception e) {

        }
        long end = System.currentTimeMillis();
        System.out.println("耗时： =======================>" + (end - start));
    }
}

class MyThread extends Thread {

    private CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i ++) {
                    if ((i % 2) == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}