package com.amber.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 订餐系统会用到。一个位置是Lock多个位置是Semaphore
 */
public class SemaphoreDemo {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6 ; i ++) {
            int temp = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("客人进入" + temp);
                    TimeUnit.SECONDS.sleep(new Random().nextInt(8));
                    System.out.println( temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }).start();
        }
    }
}
