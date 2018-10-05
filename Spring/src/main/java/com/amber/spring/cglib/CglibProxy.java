package com.amber.spring.cglib;

import com.amber.spring.dao.RoomDao;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private RoomDao roomDao;

    public CglibProxy(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    /**
     * 生成cglib代理
     */
    public Object getRoomDao() {
        //成生cglib的核心类对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(roomDao.getClass());
        //设置回调
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("room before");
        return methodProxy.invokeSuper(proxy, args);
    }
}
