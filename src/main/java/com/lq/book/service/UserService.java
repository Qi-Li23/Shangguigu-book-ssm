package com.lq.book.service;

import com.lq.book.bean.User;

/**
 * @author qili
 * @create 2022-01-15-15:56
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    void registerUser(User user);

    /**
     * 登录
     * @param username
     * @param password
     * @return 返回null说明登录失败，否则登录成功
     */
    User login(String username, String password);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，不可用，反之用户名不存在，可用
     */
    boolean existsUsername(String username);
}
