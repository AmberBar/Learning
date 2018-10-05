package com.amber.demo;

import java.util.Date;

public class ThreadAnonymous {

    public static void main(String[] args) {
        try {
            System.out.println(new Date().getSeconds());
            Thread.sleep(5000);
            System.out.println(new Date().getSeconds());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

