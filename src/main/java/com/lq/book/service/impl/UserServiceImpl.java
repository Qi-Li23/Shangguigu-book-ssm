package com.lq.book.service.impl;

import com.lq.book.bean.User;
import com.lq.book.dao.UserMapper;
import com.lq.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qili
 * @create 2022-01-15-15:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public void registerUser(User user) {
        mapper.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return mapper.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean existsUsername(String username) {
        User user = mapper.queryUserByUsername(username);
        if(user == null) {
            return false;
        } else {
            return true;
        }
    }
}
