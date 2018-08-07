package com.iotek.dao;

import com.iotek.model.Depa;

import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
public interface DepaMapper {
    boolean deleteDepa(int id);
    boolean updateDepa(Depa depa);
    boolean saveDepa(Depa depa);
    List<Depa> getAllDepa();
    List<Depa> getAllDepaByPage(int begin,int end);
    Depa getDepaByDid(int did);
    Depa getDepaByDid1(int did);//无需职位关联
}
