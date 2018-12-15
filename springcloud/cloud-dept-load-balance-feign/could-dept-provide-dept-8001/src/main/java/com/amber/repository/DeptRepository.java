package com.amber.repository;

import com.amber.springcloud.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
    Dept findOneById(Integer id);
}
