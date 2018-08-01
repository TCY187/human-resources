package com.iotek.service;

import com.iotek.model.Depa;

/**
 * Created by TCY on 2018/7/27.
 */
public interface DepaService {
    boolean deleteDepa(int id);

    boolean updateDepa(Depa depa);

    boolean saveDepa(Depa depa);
}