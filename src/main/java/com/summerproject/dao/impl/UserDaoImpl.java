package com.summerproject.dao.impl;

import com.summerproject.dao.UserDao;
import com.summerproject.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `ID`, `username`, `password`, `mobile_no` from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `ID`, `username`, `password`, `mobile_no` from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user (`username`, `password`, `mobile_no`) value(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getMobile_no());
    }
}
