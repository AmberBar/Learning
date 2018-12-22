package com.amber.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 产生虚假唤醒
 */
public class ProductConsumerDemo_02 {

    public static void main(String[] args){
        Clert_02 clert_02 = new Clert_02();
        Product product = new Product(clert_02);
        Consumer consumer = new Consumer(clert_02);
        new Thread(product).start();
        new Thread(consumer).start();
        new Thread(product).start();
        new Thread(consumer).start();
    }
}

class Clert_02 {
    private int num;
    Lock lock = new ReentrantLock();
    Condition condition_1 = lock.newCondition();
    public void get() {
        lock.lock();
        try {
            if(num >= 1) {
                System.out.println("产品满了" + num);
                try {
                    TimeUnit.MICROSECONDS.sleep(200);
                    condition_1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println( Thread.currentThread().getName() + "===product===" + ++num);
            condition_1.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void sale() {
        lock.lock();
        try {
            if (num <= 0) {
                System.out.println("缺货" + num);
                try {
                    TimeUnit.MICROSECONDS.sleep(200);
                    condition_1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "===consumer===" + --num);
            condition_1.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class Product implements Runnable{

    private Clert_02 clert;
    public Product(Clert_02 clert){
        this.clert = clert;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 20 ; i ++) {
            clert.get();
        }
    }
}

class Consumer implements Runnable{
    private Clert_02 clert;
    public Consumer(Clert_02 clert){
        this.clert = clert;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 20 ; i ++) {
            clert.sale();
        }
    }
}