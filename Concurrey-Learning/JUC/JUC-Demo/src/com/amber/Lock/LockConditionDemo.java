package com.amber.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程按需交替
 */
public class LockConditionDemo {

    public static void main(String[] args){
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(() -> {
            for (int i = 1; i < 20 ; i ++) {
                alternateDemo.loop_a(i);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 20 ; i ++) {
                alternateDemo.loop_b(i);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 20 ; i ++) {
                alternateDemo.loop_c(i);
            }
        }, "C").start();
    }
}


class AlternateDemo{

    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition_1 = lock.newCondition();
    Condition condition_2 = lock.newCondition();
    Condition condition_3 = lock.newCondition();
    public void loop_a(int loop){
        lock.lock();
        try {
            if (number != 1) {
                condition_1.await();
            }
            for (int i = 0 ; i < 5 ; i ++) {
                System.out.println("AAAAA" + "             "+ i + "      " + loop);
            }
            number = 2;
            condition_2.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void loop_b(int loop){
        lock.lock();
        try {
            if (number != 2) {
                condition_2.await();
            }
            for (int i = 0 ; i < 5 ; i ++) {
                System.out.println("BBBBBBBBBB" + "             "+ i + "      " + loop);
            }
            number = 3;
            condition_3.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void loop_c(int loop){
        lock.lock();
        try {
            if (number != 3) {
                condition_3.await();
            }
            for (int i = 0 ; i < 5 ; i ++) {
                System.out.println("CCCCCCCCC" + "             "+ i + "      " + loop);
            }
            number = 1;
            condition_1.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}