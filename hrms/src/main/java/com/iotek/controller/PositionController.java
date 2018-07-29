package com.iotek.controller;

import com.iotek.service.PositionService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/27.
 */
@Controller
public class PositionController {
    @Resource
    private PositionService positionService;
}
