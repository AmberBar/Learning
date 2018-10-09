package com.amber.demo;

public class TestThread {

    public static void main(String[] args) {
        //4.创建Thread的子类对象
        MyThread myThread = new MyThread();

        //5.启动线程，注意这里使用的是start而不是run方法
        myThread.start();

        for (int i = 0; i < 10000; i ++) {
            System.out.println("This is main thread");
        }
    }


}

//1.继承Thread
class MyThread extends  Thread{

    //2.重写run方法
    @Override
    public void run() {
        super.run();
        //3.线程方法中要执行的代码，可以根据自己的需求填写
        for(int i = 0 ; i < 10000 ; i ++ ) {
            System.out.println("This is MyThread thread ");
        }
    }
}
