package com.lq.book.dao;

import com.lq.book.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author qili
 * @create 2022-01-15-15:42
 */
public interface UserMapper {

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return 返回null, 表示没有该用户，否则有该用户
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查找用户信息
     * @param username
     * @param password
     * @return 若返回null, 说明用户名或密码错误
     */
    User queryUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，其他是SQL语句影响的行数
     */
    Integer saveUser(User user);
}
