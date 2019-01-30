package com.amber.repository;

import com.amber.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承了Repository,缺点只能对所有的数据进行排序或者分页
 */
@Repository
public interface UserPagingAndSortingReposiroty extends PagingAndSortingRepository<User, Integer> {
}
