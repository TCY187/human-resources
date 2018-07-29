package com.iotek.controller;

import com.iotek.service.EmpService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/27.
 */
@Controller
public class EmpController {
    @Resource
    private EmpService empService;
}
