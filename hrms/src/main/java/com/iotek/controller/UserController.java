package com.iotek.controller;

import com.iotek.model.User;
import com.iotek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by TCY on 2018/7/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model){
        User user1 = userService.getUserByNameAndPass(user);
        if (null!=user1){
            session.setAttribute("user",user1);
            return "success";
        }else {
            model.addAttribute("error","用户名或密码错误");
            return "../../login";
        }
    }
    @RequestMapping("/register1")
    public String register1(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user, HttpSession session, Model model){
        boolean flag= userService.saveUser(user);
        if (flag){
            session.setAttribute("user",user);
            return "success";
        }else {
            model.addAttribute("error","用户名重复，注册失败");
            return "register";
        }
    }
}
