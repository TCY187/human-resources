package com.iotek.dao;

import com.iotek.model.Manager;

/**
 * Created by TCY on 2018/7/27.
 */
public interface ManagerMapper {
    Manager getManByNAndP(Manager manager);
}
