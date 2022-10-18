package com.summerproject.web;

import com.summerproject.pojo.User;
import com.summerproject.service.UserService;
import com.summerproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String code = req.getParameter("code");

        // 2.检查验证码是否正确（先将验证码写死）
        if ("abcde".equalsIgnoreCase(code)) {
            // 如果正确

            // 3.检查用户名是否可用
            if (userService.existUsername(username)) {
                // 如果不可用，跳回注册页面
                System.out.println("用户名[" + "]已存在！");

                // 把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("phone", phone);

                // 跳回注册页面
                req.getRequestDispatcher("/pages/User/Regist.jsp").forward(req, resp);
            } else {
                // 如果可用，调用service保存到数据库
                // 并且跳转到注册成功页面
                userService.registUser(new User(null, username, password, phone));
                req.getRequestDispatcher("/pages/User/RegistSuccess.jsp").forward(req, resp);
            }
        } else {
            // 把回显信息，保存到Request页面
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("phone", phone);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/User/Regist.jsp").forward(req, resp);
        }
    }
}
