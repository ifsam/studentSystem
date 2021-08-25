package com.qin.dao;

import com.qin.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryUser(String userName, String passWord);
}
