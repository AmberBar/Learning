package com.amber;

import com.amber.pojo.User;
import com.amber.repository.UserCrudReposiroty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAApplication.class)
public class UserCrudRepostoryTest {
    @Autowired
    UserCrudReposiroty userCrudReposiroty;

    /**
     * 向数据库中添加数据，如果存在的话就更新
     */
    @Test
    public void save(){
        User user = new User();
        user.setName("amber");
        user.setAge(18);
        user.setAddress("shanghai");
        userCrudReposiroty.save(user);
    }

    /**
     * 根据ID查找
     */
    @Test
    public void findById(){
        User user = userCrudReposiroty.findById(0).get();
        System.out.println(user);
    }
}
