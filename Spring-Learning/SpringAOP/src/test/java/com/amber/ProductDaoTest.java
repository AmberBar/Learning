package com.amber;

import com.amber.dao.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void beforeTest() {
        productDao.create();
    }

    @Test
    public void afterTest() {
        productDao.delete();
    }

    @Test
    public void afterReturingTest() {
        productDao.update();
    }

    @Test
    public void aroundTest() {
        productDao.addBatch();
    }

    @Test
    public void delBatchTest() {
        productDao.delBatch();
    }
}
