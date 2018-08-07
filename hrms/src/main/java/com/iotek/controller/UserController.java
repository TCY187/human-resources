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
            model.addAttribute("logerror","��ӭ�㣬�ѵ�¼");
            return "../../login";
        }else {
            model.addAttribute("logerror","�û������������");
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
            return "../../login";
        }else {
            model.addAttribute("regerror","�û����ظ���ע��ʧ��");
            return "register";
        }
    }
}
