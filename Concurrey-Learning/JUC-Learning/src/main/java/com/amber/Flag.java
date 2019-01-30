package com.amber;

public class Flag {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        while (true ) {
            synchronized (myThread) {
                if (myThread.getFlag()) {
                    System.out.println("-------------------");
                    break;
                }
            }

        }
    }
}

class MyThread extends Thread {

    private boolean flag;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
            this.flag = true;
            System.out.println("改变flag" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getFlag() {
        return flag;
    }
}
