package com.amber.demo;

public class ThreadSynchronied {

    public static void main(String[] args) {
        final Say say = new Say();

         Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0 ; i < 10000 ; i ++) {
                    say.say();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0 ; i < 10000 ; i ++) {
                    say.say1();
                }
            }
        };
        //设置最大的线程优先级最大为10
        thread1.setPriority(Thread.MIN_PRIORITY);
        //设置最小的线程优先级，最小为１
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}

class Say {
    String s = "hahaah";

    synchronized void say() {
        synchronized (s) {
            System.out.print("s ");
            System.out.print("a ");
            System.out.print("y ");
            System.out.print("h ");
            System.out.print("e ");
            System.out.print("l ");
            System.out.print("l ");
            System.out.println("o");
        }
    }




     void say1() {
        synchronized (s) {
            System.out.print("1 ");
            System.out.print("2 ");
            System.out.print("3 ");
            System.out.print("4 ");
            System.out.print("5 ");
            System.out.print("6 ");
            System.out.print("7 ");
            System.out.println("8");
        }
    }
}
