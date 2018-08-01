package com.iotek.dao;

import com.iotek.model.Depa;

/**
 * Created by TCY on 2018/7/27.
 */
public interface DepaMapper {
    boolean deleteDepa(int id);
    boolean updateDepa(Depa depa);
    boolean saveDepa(Depa depa);
}
