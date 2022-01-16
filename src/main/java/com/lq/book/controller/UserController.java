package com.lq.book.controller;

import com.lq.book.bean.User;
import com.lq.book.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author qili
 * @create 2022-01-15-16:22
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(User user, String code, HttpSession session) {
        session.setAttribute("username", user.getUsername());
        session.setAttribute("email", user.getEmail());
        //1.检查验证码是否正确
        if("abcde".equalsIgnoreCase(code)) {
            //1)正确
            //1.1)检查用户名是否可用
            boolean existsUsername = userService.existsUsername(user.getUsername());
            if(existsUsername) {
                //不可用  跳回注册页面
                session.setAttribute("errorMsg", "用户名已被占用！");
                return "redirect:/user/regist";
            } else {
                //可用   调用userService的registerUser()
                userService.registerUser(user);
                session.setAttribute("user", user);
                //跳转到注册成功页面
                return "redirect:/user/regist_success";
            }
        } else {
            //2)不正确
            // 跳回注册页面
            session.setAttribute("errorMsg", "验证码错误！");
            return "redirect:/user/regist";
        }
    }

    @RequestMapping(value = "/logins", method = RequestMethod.POST)
    public String userLogin(String username, String password, HttpSession session) {
        //调用userService的login()
        User login = userService.login(username, password);
        if(login == null) {
            //返回null,说明登录失败，用户名或密码错误
            session.setAttribute("errorMsg", "用户名或密码错误!");
            session.setAttribute("username", username);
            //重定向到登录页面
            return "redirect:/user/login";
        } else {
            //否则，登陆成功，重定向到login_success页面
            session.setAttribute("user", login);
            return "redirect:/user/login_success";
        }
    }
}
