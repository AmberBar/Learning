package com.amber.spring.jdkProxy;

import com.amber.spring.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建代理类，并实现InvocationHandler
 */
public class JdkProxy implements InvocationHandler {

    private UserDao userDao;

    /**
     *
     * 利用构造方法，传入被代理类
     * @param userDao
     */
    public JdkProxy(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    /**
     * 获得代理对象
     * @return
     */
    public Object getUserDao() {
        return  Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), this);
    }

    /**
     * 在执行say方法之前，打印出一句话
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("people listener");
        return method.invoke(userDao, args);
    }
}
