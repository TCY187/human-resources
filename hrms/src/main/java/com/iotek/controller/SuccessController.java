package com.iotek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by TCY on 2018/7/16.
 */
@Controller
public class SuccessController {
    @RequestMapping("/success1")
    public String success(){
        return "../../login";
    }
    @RequestMapping("/msuccess")
    public String msuccess(){
        return "managerSuccess";
    }
    @RequestMapping("/esuccess")
    public String esuccess(){
        return "empSuccess";
    }
    @RequestMapping("/manlogin1")
    public String manlogin1(){
        return "manlogin1";
    }
    @RequestMapping("/emplogin1")
    public String emplogin1(){
        return "emplogin1";
    }
}
