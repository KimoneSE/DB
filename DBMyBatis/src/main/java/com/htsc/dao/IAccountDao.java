package com.htsc.dao;

import com.htsc.domain.AccountUser;

import java.util.List;

/**
 * created by Kimone
 * date 2020/9/2
 */
public interface IAccountDao {
    List<AccountUser> findAll();
}
