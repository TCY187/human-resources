package com.iotek.dao;

/**
 * Created by TCY on 2018/8/3.
 */
public interface ECMapper {
    boolean saveEC(int eid,int cid);
    boolean deleteECByCid(int cid);
}
