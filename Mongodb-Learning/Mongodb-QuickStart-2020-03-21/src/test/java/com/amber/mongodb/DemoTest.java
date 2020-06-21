package com.amber.mongodb;

import com.amber.mongodb.pojo.Comment;
import com.amber.mongodb.repository.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: Amber
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void findAll() {
        List<Comment> all = commentRepository.findAll();
        all.stream().forEach(System.out::println);
    }

    @Test
    public void insert() {
        Comment comment = new Comment();
        comment.setNickname("123");
        Comment insert = commentRepository.insert(comment);
        System.out.println(insert);
    }

    @Test
    public void findById() {

        Comment comment = commentRepository.findById("5eef2a2e158b136018d4db2c").get();
        System.out.println(comment);
    }

    @Test
    public void deleteCommentById()
    {
        commentRepository.deleteById("5eef2a2e158b136018d4db2c");
    }

    @Test
    public void findPage()
    {
        Sort.Order id = Sort.Order.desc("id");
        Sort sort = new Sort(id);
        Page<Comment> byParentid = commentRepository.findByParentid("1", PageRequest.of(0, 2, sort));
        System.out.println(byParentid.getContent());
        System.out.println(byParentid.getTotalPages());
        System.out.println(byParentid.getTotalElements());
    }

    @Test
    public void update() {
        //查询对象 Query query=Query.query(Criteria.where("_id").is(id));
        // 更新对象 Update update=new Update(); /
        // /局部更新，相当于$set // update.set(key,value) //递增$inc // update.inc("likenum",1); update.inc("likenum"); //参数1：查询对象 //参数2：更新对象 //参数3：集合的名字或实体类的类型Comment.class mongoTemplate.updateFirst(query,update,"comment")

        Query query=Query.query(Criteria.where("_id").is("1"));
        Update update = new Update();
        update.set("articleid", "001");
        mongoTemplate.updateFirst(query, update, "comment");
    }
}
