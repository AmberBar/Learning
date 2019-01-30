package com.amber.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AddOption {

    public void addSave() {

        System.out.println("save room before");
    }

    public void addAfter() {
        System.out.println("save room after");
    }

    public void addAfterReturn(Object result) {
        System.out.println("save room after-return " + result);
    }

    /**
     * 环绕
     */
    public Object addAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        //执行目标程序
        Object object = joinPoint.proceed();
        System.out.println("around after");
        return object;
    }

    /**
     * 环绕
     */
    public void addAfterThrowing(Throwable e)   {
        System.out.println("after throwing" + e.getMessage());

    }
}
