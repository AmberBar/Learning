package com.amber.Lock;

/**
 * Join不是JUC里面的，用Join实现ABC三个线程按顺序执行
 */
public class JoinDemo {

    public static void  main(String[] args){
        Thread thread3 = new Thread(() -> {
            for(int i = 0; i < 20 ; i ++) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "CC");
        Thread thread2 = new Thread(() -> {

            try {
                thread3.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            for(int i = 0; i < 20 ; i ++) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "BB");

        Thread thread1 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            for(int i = 0; i < 20 ; i ++) {
                System.out.println(Thread.currentThread().getName());
            }

        }, "AA");
        thread3.start();
        thread2.start();
        thread1.start();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {

    }
}
