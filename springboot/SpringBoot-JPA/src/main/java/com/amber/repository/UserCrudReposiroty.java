package com.amber.repository;

import com.amber.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudReposiroty extends CrudRepository<User, Integer> {
}
