package com.summerproject.test;

import com.summerproject.web.UserServlet;

import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("这是login()方法调用了");
    }

    public void regist(){
        System.out.println("这是regist()方法调用了");
    }

    public void updateUser(){
        System.out.println("这是updateUser()方法调用了");
    }

    public void updateUserPassword(){
        System.out.println("这是updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            Method method = UserServlet.class.getDeclaredMethod(action);
            System.out.println(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
