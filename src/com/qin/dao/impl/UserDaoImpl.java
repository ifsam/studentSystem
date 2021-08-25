package com.qin.dao.impl;

import com.qin.dao.UserDao;
import com.qin.entity.User;
import com.qin.utils.MysqlUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(MysqlUtils.getDataSource());
    @Override
    public List<User> queryUser(String userName, String passWord) {
        String sql = "select * from user where userName = ? and pass = ?";
//        User user = template.queryForObject(sql, User.class,userName,passWord);
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), userName, passWord);
        return users;
    }
}
