package com.amber.repository;

import com.amber.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository接口
 */
@Repository
public interface UserRepositorySave extends JpaRepository<User, Integer> {

}
