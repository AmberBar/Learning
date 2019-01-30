package com.amber.demo;

public class ThreadJoin {

    public static void main(String[] args) {
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
            super.run();
            for(int i = 0; i < 500; i ++) {
                System.out.println("thread1---" + i);
            }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 200; i ++) {
                    if (i == 20) {
                        try {
                            thread1.join(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}

