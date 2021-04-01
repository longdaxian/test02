package com.daxian.dao;

import com.daxian.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findall();
}
