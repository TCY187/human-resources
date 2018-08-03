package com.iotek.service.impl;

import com.iotek.dao.SalMapper;
import com.iotek.service.SalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/8/3.
 */
@Service
public class SalServiceImpl implements SalService{
    @Resource
    private SalMapper salMapper;
}
