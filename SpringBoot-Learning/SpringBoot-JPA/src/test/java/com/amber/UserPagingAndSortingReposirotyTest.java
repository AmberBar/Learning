package com.amber;

import com.amber.pojo.User;
import com.amber.repository.UserPagingAndSortingReposiroty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAApplication.class)
public class UserPagingAndSortingReposirotyTest {

    @Autowired
    UserPagingAndSortingReposiroty userPagingAndSortingReposiroty;

    /**
     * 排序
     */
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

    /**
     * 分页Pageable封装了分页的参数，当前页，每一页显示的条数，注意当前页是从0开始的
     */
    @Test
    public void TestPaging(){
        //Pageable是个接口
        Pageable pageable = new PageRequest(0, 10);
        //返回Page对象
        Page<User> uses = userPagingAndSortingReposiroty.findAll(pageable);
        System.out.println(uses.getContent());
        System.out.println(uses.getTotalElements());
        System.out.println(uses.getTotalPages());
        System.out.println(uses.getNumberOfElements());
    }

    /**
     * 分页 + 排序
     */
    @Test
    public void TestPagingAndSort(){
        //定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "id");
        //Sort
        Sort sort = new Sort(order, order1);
        //Pageable是个接口
        Pageable pageable = new PageRequest(0, 10, sort);
        //返回Page对象
        Page<User> uses = userPagingAndSortingReposiroty.findAll(pageable);
        System.out.println(uses.getContent());
        System.out.println(uses.getTotalElements());
        System.out.println(uses.getTotalPages());
        System.out.println(uses.getNumberOfElements());
    }

}
