package com.iotek.service.impl;

import com.iotek.dao.DepaMapper;
import com.iotek.service.DepaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/27.
 */
@Service
public class DepaServiceImpl implements DepaService{
    @Resource
    private DepaMapper depaMapper;
}
