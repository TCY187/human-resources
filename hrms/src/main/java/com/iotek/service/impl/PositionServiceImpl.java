package com.iotek.service.impl;

import com.iotek.dao.PositionMapper;
import com.iotek.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/27.
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Resource
    private PositionMapper positionMapper;
}
