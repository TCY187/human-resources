package com.iotek.service;

import com.iotek.model.Depa;

import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
public interface DepaService {
    boolean deleteDepa(int id);
    boolean updateDepa(Depa depa);
    boolean saveDepa(Depa depa);
    List<Depa> getAllDepa();
    Depa getDepaByDid(int did);
    List<Depa> getAllDepaByPage(int begin,int end);
}