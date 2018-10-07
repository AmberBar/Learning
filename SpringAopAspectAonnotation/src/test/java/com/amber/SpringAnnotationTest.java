package com.amber;

import com.amber.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringAnnotationTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void beforeTest() {
        userDao.save();
    }

    @Test
    public void afterReturnTest() {
        userDao.create();
    }

    @Test
    public void afterReturn() {
        userDao.delete();
    }

    @Test
    public void afterThrowing() {
        userDao.update();
    }

    @Test
    public void aroundTest() {
        userDao.batchUpdate();
    }

    @Test
    public void pointCutTest() {
        userDao.batchDelete();
    }
}
