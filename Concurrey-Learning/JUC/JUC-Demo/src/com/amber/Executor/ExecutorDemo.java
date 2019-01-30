package com.amber.Executor;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorDemo {

    public static void main(String[] args){
        new ExecutorDemo().exectuorService();
    }

    /**
     * 线程池调度
     */
    public void exectuorService() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<Integer> scheduledFuture = null;
        for (int i = 0; i < 100 ; i ++) {
            int temp = i;
            //每隔一段时间发布
            try {
                scheduledFuture = executor.schedule(() -> {
                    System.out.println(Thread.currentThread().getName() + "   " );
                    return new Random().nextInt(8);
                }, 200, TimeUnit.MICROSECONDS);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void exectuorPool() {
        //需要多少就创建多少
//        ExecutorService executor = Executors.newCachedThreadPool();
        //只有一个线程
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        //指定数量的线程
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i ++) {
            int temp = i;
            new Thread(() -> {
                executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + " " + temp);
                });
            }).start();
        }
    }
}
