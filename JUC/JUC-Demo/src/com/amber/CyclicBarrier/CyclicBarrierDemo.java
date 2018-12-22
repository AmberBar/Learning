package com.amber.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier和CountDownLatch很像，一个是相加，一个是相减
 */
public class CyclicBarrierDemo {

    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("--------------------");
        });
        for (int i = 0 ; i < 7; i++) {
            int temp = i;
            new Thread(() -> {
                try {
                    System.out.println("    " + temp);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
