package com.amber.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class addOptions {

    @Before("execution(* com.amber.dao.UserDao.save(..))")
    public void before() {
        System.out.println("***before***");
    }

    @After("execution(* com.amber.dao.UserDao.delete(..))")
    public void after() {
        System.out.println("***after***");
    }

    @AfterReturning(value = "execution(* com.amber.dao.UserDao.create(..))", returning = "result")
    public void afterReturn(Object result) {
        System.out.println("***afterReturn***" + result);
    }

    @AfterThrowing(value = "execution(* com.amber.dao.UserDao.update(..))", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("***afterThrowing***" );
        System.out.println(e);
    }

    @Around(value = "execution(* com.amber.dao.UserDao.batchUpdate(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("***around  before***");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("***around  after***");
    }
}
