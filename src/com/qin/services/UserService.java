package com.qin.services;

import com.qin.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUser(String userName, String passWord);
}
