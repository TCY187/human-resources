package com.iotek.controller;

import com.iotek.model.Manager;
import com.iotek.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by TCY on 2018/7/27.
 */
@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @RequestMapping("/manlogin")
    public String manlogin(Manager manager, HttpSession session, Model model){
        Manager manager1 = managerService.getManByNAndP(manager);
        if (null!=manager1){
            session.setAttribute("manager",manager1);
            return "managerSuccess";
        }else {
            model.addAttribute("manlogerror","用户名或密码错误");
            return "manlogin1";
        }
    }
}
