package com.iotek.service.impl;

import com.iotek.dao.EmpMapper;
import com.iotek.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/27.
 */
@Service
public class EmpServiceImpl implements EmpService{
    @Resource
    private EmpMapper empMapper;
}
