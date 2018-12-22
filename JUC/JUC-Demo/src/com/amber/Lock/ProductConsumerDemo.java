package com.amber.Lock;

/**
 * 产生虚假唤醒,本来应该生成和消费都会只执行20次后，程序正常结束。
 * 但是程序可能在this.wait()的时候所有循环次数就以及完成了，没有其他线程调用this.notify()唤醒
 * 程序就一直不结束
 */
public class ProductConsumerDemo {

    public static void main(String[] args){
        Clert clert = new Clert();
        for (int i = 0; i < 100; i ++) {
            new Thread(() -> {
                clert.product();
            }).start();
            new Thread(() -> {
                clert.consumer();
            }).start();
        }
    }
}

class Clert {
    private int num;
    public synchronized void product() {
        if(num >= 1) {
            System.out.println("产品满了");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(++num);
            this.notifyAll();
        }
    }

    public synchronized void consumer() {
        if (num < 1) {
            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(--num);
            this.notifyAll();
        }
    }
}
