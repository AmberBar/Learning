package com.amber.spring.aspectj;

import com.amber.spring.dao.RoomDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddOptionTest {

    @Autowired
    RoomDao roomDao;

    @Test
    public void test1() {
        roomDao.save();
    }

}
