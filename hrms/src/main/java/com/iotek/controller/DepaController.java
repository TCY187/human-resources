package com.iotek.controller;

import com.iotek.service.DepaService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/27.
 */
@Controller
public class DepaController {
    @Resource
    private DepaService depaService;
}
