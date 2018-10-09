package com.amber.runnable;

/**
 * 实现Runnable多线程
 */
public class RunnableDemo {

    public static void main(String[] args) {
        //创建Runnable实现类
        Runnable runnable = new MyRunnable();
        //把runnable作为构造参数传给thread
        new Thread(runnable).start();
        for (int i = 0 ; i < 10000 ; i ++) {
            System.out.println("===============main ===============");
        }
    }
}

/**
 * 实现runnable
 */
class MyRunnable implements Runnable {
    /**
     * 重写run方法
     */
    public void run() {
        for (int i = 0 ; i < 10000 ; i ++) {
            System.out.println("===============runnable ===============");
        }

    }
}
