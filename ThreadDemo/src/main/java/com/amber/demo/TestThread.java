package com.amber.demo;

public class Test {

    public static void main(String[] args) {
        for (int i = 0 ; i < 100000 ; i ++) {
            new demo1();
        }

        for (int i = 0 ; i < 100000 ; i ++) {
            System.out.println("我是主线程");
        }
    }


}

class demo1 {
    @Override
    protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("垃圾被回收来了");
    }
}
