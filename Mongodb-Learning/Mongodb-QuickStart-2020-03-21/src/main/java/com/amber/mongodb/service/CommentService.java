package com.amber.mongodb.service;

import com.amber.mongodb.pojo.Comment;

import java.util.List;

/**
 * @Author: Amber
 */
public interface CommentService {

    public List<Comment> findAll();
}
