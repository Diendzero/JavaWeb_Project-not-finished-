package com.summerproject.web;

import com.summerproject.pojo.User;
import com.summerproject.service.UserService;
import com.summerproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.调用userService.login()对象登录处理业务
        User loginUser = userService.Login(new User(null, username, password, null));

        // 3.如果是null表示登录失败！
        if (loginUser == null) {
            // 将错误信息和回显表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或者密码错误！");
            req.setAttribute("username", username);

            // 登陆失败，跳转到登陆页面
            req.getRequestDispatcher("/pages/User/Login.jsp").forward(req, resp);
        } else {
            // 登陆成功，跳转到LoginSuccess.html
            req.getRequestDispatcher("/pages/User/LoginSuccess.jsp").forward(req, resp);
        }
    }
}
