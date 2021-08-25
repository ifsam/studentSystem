package com.qin.services.impl;

import com.qin.dao.UserDao;
import com.qin.dao.impl.UserDaoImpl;
import com.qin.entity.User;
import com.qin.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao =new UserDaoImpl();

    @Override
    public List<User> getUser(String userName, String passWord) {
        return userDao.queryUser(userName,passWord);
    }
}
