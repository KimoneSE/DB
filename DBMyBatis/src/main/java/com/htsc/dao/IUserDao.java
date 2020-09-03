package com.htsc.dao;

import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVoIds;
import com.htsc.domain.User;

import java.util.List;

/**
 * created by Kimone
 * date 2020/9/2
 */
public interface IUserDao {
    List<User> findAll();

    User findById(Integer userId);

    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(Integer userId);

    List<User> findByName(String username);

    int count();

    List<User> findByVo(QueryVo vo);

    List<User> findInIds(QueryVoIds queryVoIds);
}