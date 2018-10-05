package com.amber.demo;

public class ThreadDaemon {

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                for(int i = 0; i < 5; i ++) {
                    System.out.println("非守护线程");
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 200; i ++) {
                    System.out.println("守护线程");
                }
            }
        };

        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
    }


}

