package com.amber.aspectJ.pointcut;

import org.aspectj.lang.annotation.*;

@Aspect
public class Options {

    /**
     * 注解方式定义切入点
     */
    @Pointcut("execution(* com.amber.dao.UserDao.batchDelete(..))")
    public void pointcut() {}

    /**
     * 前置通知
     */
    @Before("Options.pointcut()")
    public void before() {
        System.out.println("***before***");
    }

    /**
     * 最终通知
     */
    @After("Options.pointcut()")
    public void after() {
        System.out.println("***after***");
    }
}
