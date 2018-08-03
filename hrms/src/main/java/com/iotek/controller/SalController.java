package com.iotek.controller;

import com.iotek.service.SalService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/8/3.
 */
@Controller
public class SalController {
    @Resource
    private SalService salService;
}
