package com.summerproject.test;

import com.summerproject.pojo.User;
import com.summerproject.service.UserService;
import com.summerproject.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "user1", "111111", "11111111111"));
        userService.registUser(new User(null, "user2", "222222", "22222222222"));
    }
    @Test
    public void login() {
        System.out.println(userService.Login(new User(null, "admin", "12345", "13626192186")));

    }

    @Test
    public void existUsername() {
        if (userService.existUsername("admi")) {
            System.out.println("用户名已经存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}