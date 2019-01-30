package com.amber.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket();
        new Thread(() -> {
            saleTicket.decrease();
        }).start();

        new Thread(() -> {
            saleTicket.decrease();
        }).start();

        new Thread(() -> {
            saleTicket.decrease();
        }).start();

    }
}

class SaleTicket {
    private int ticket = 100;
    Lock lock = new ReentrantLock();
    public void decrease() {
        lock.lock();
        try {
            while (ticket > 0){
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(--ticket);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}