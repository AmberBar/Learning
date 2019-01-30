package com.amber.ReadWriteLock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 写写互斥，读写互斥
 * 读读不需要互斥
 *
 */
public class ReadWriteLockDemo {

    public static void main(String[] args){
        ReadWriteLocakResource readWriteLocakResource = new ReadWriteLocakResource();
        for (int i = 0; i < 100; i ++) {
            new Thread(() -> {
                readWriteLocakResource.write(new Random().nextInt());
            }).start();
        }

        for (int i= 0 ; i < 100 ; i ++) {
            new Thread(() -> {
                readWriteLocakResource.read();
            }).start();
        }
    }
}

class ReadWriteLocakResource {
    private int num = 100;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void read(){
        readWriteLock.readLock().lock();
        try{
            System.out.println("read" + num);
        }finally {
            readWriteLock.readLock().unlock();
        }

    }

    public void write(int num){
        readWriteLock.writeLock().lock();
        try {
            this.num = num;
            System.out.println("write"+ num);
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
