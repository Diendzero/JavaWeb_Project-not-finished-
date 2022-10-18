package com.summerproject.test;

import com.summerproject.dao.UserDao;
import com.summerproject.dao.impl.UserDaoImpl;
import com.summerproject.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "123456") == null) {
            System.out.println("用户名或者密码错误！");
        }else {
            System.out.println("查询成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "admin", "123456", "13626192186")));
    }
}