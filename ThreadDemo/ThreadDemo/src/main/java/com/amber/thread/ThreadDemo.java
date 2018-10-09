package com.amber.thread;

/**
 *　继承Thread实现多线程例子
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        for (int i = 0 ; i < 10000 ; i ++) {
            System.out.println("主线程");
        }

    }
}

/**
 * 继承Thread实现多线程
 */
class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0 ; i < 10000 ; i ++) {
            System.out.println("============继承java.lang.Thread实现多线程=================");
        }

    }
}
