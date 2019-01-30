package com.amber.repository;

import com.amber.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * 1.根据方法名称命名查询
 * 2.Query可以查询，也可以更新
 */
@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Integer> {

    List<User> findByName(String name);

    /**
     * HQL 默认 nativeQuery是false 执行的时候默认会被转化成SQL
     * @param name
     * @return
     */
    @Query("from User Where name = ?1")
    List<User> findByUsername(String name);

    /**
     * SQL nativeQuery的值是true 执行的时候不用再转化
     * @param name
     * @return
     */
    @Query(value = "SELECT * FROM table_user WHERE name = ?1", nativeQuery = true)
    List<User> findByUsernameSQL(String name);

    /**
     * 基于HQL
     * @param name
     * @param id
     * @return
     */
    @Query("Update User set name = ?1 WHERE id = ?2")
    @Modifying
    int updateNameAndId(String name, Integer id);

}
