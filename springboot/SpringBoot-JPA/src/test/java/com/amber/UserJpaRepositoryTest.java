package com.amber;

import com.amber.pojo.User;
import com.amber.repository.UserJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAApplication.class)
public class UserJpaRepositoryTest {
    @Autowired
    UserJpaRepository userJpaRepository;
    @Test
    public void testJpaRepository() {
        List<User> users = userJpaRepository.findAll();
        System.out.println(users);
    }
}
