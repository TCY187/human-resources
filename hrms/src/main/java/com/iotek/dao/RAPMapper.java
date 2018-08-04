package com.iotek.dao;

import com.iotek.model.RAP;

import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
public interface RAPMapper {
    boolean saveRAP(RAP rap);
    List<RAP> getRAPByEid(int eid);
    List<RAP> getRAPByEidAndPage(int eid,int begin,int end);
    RAP getRAPByEidAndSateAndSysdate(int eid,int state);//查找当天某状态的记录
    boolean deleteRAPByRAid(int raid);
}
