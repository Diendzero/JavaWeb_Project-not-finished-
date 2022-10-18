package com.summerproject.service;

import com.summerproject.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登陆失败。返回有值，则是登录成功。
     */
    public User Login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已经存在，返回false表示用户名可以创建
     */
    public boolean existUsername(String username);

}
