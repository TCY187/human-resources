package com.iotek.service.impl;

import com.iotek.dao.ManagerMapper;
import com.iotek.model.Manager;
import com.iotek.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by TCY on 2018/7/27.
 */
@Service
public class ManagerServiceImpl implements ManagerService{
    @Resource
    private ManagerMapper managerMapper;

    public Manager getManByNAndP(Manager manager) {
        return managerMapper.getManByNAndP(manager);
    }
}
