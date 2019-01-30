package com.amber.callable;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * 实现Callable接口
 */
public class CallableDemo {

    public static void main(String[] args) {
        //创建Callable实现类
        Callable callable = new MyCallable();
        /*
            把Callable实现类作为构造参数，创建FutureTask
            FutureTask实现了RunnableFuture
            RunnableFuture实现了Runnable 和Future接口
            因此可以把FutureTask的实现类作为Thread的构造参数开启线程
         */
        FutureTask<UUID> uuidFutureTask = new FutureTask<UUID>(new MyCallable());
        //开启线程
        new Thread(uuidFutureTask).start();
        try {
            UUID result = uuidFutureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (int i = 0 ; i < 200 ; i ++) {
            System.out.println("==========main===================");
        }

    }
}

/**
 * 实现callable接口
 */
class MyCallable implements Callable {
    /**
     * 重写call方法，而继承Thread实现Runnable都是重写Run方法，并且call方法可以抛出异常和返回值
     * @return
     * @throws Exception
     */
    public UUID call() throws Exception {
        for (int i = 0 ; i < 90000 ; i ++) {
            System.out.println("============callable=================");
            if (i == 66666) {
                return UUID.randomUUID();
            }
        }
        return null;
    }
}
