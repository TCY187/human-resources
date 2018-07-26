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
}
