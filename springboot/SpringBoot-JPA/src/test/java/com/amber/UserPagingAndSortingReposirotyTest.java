package com.amber;

import com.amber.pojo.User;
import com.amber.repository.UserPagingAndSortingReposiroty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAApplication.class)
public class UserPagingAndSortingReposirotyTest {

    @Autowired
    UserPagingAndSortingReposiroty userPagingAndSortingReposiroty;
    @Test
    public void TestSort(){
        //定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "id");
        //Sort
        Sort sort = new Sort(order, order1);
        List<User> users = (List<User>)userPagingAndSortingReposiroty.findAll(sort);
        System.out.println(users);
    }
}
