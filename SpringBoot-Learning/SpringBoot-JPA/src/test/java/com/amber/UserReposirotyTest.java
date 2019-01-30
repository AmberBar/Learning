package com.amber;

import com.amber.pojo.User;
import com.amber.repository.UserRepositorySave;
import com.amber.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAApplication.class)
public class UserReposirotyTest {

    @Autowired
    UserRepositorySave userReposiroty;

    @Autowired
    UserRepository userRepository;

    /**
     * 在执行更新的时候，必须存在事务，否则会报错
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void updateNameAndId(){
        int num = userRepository.updateNameAndId("amber1", 2);
        System.out.println(num);
    }

    @Test
    public void findByUsernameSQL(){
        List<User> amber = userRepository.findByUsernameSQL("amber");
        System.out.println(amber);
    }

    @Test
    public void findByName(){
        List<User> amber = userRepository.findByName("amber");
        System.out.println(amber);
    }

    @Test
    public void findByUsername(){
        List<User> amber = userRepository.findByUsername("amber");
        System.out.println(amber);
    }

    @Test
    public void save(){
        User user = new User();
        user.setName("amber");
        user.setAge(18);
        user.setAddress("shanghai");
        userReposiroty.save(user);
    }



}
