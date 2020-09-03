package com.htsc.dao;

import com.htsc.domain.Role;

import java.util.List;

/**
 * created by Kimone
 * date 2020/9/2
 */
public interface IRoleDao {
    List<Role> findAll();
}
