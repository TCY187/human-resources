package com.iotek.service;

import com.iotek.model.RAP;

import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
public interface RAPService {
    boolean saveRAP(RAP rap);
    List<RAP> getRAPByEid(int eid,Date date);
    List<RAP> getRAPByEidAndPage(int eid,int begin,int end,Date date);
    RAP getRAPByEidAndSateAndSysdate(int eid,int state);//查找当天某状态的记录
    boolean deleteRAPByRAid(int raid);
    RAP getRAPByRAid(int raid);
    boolean updateRAPMoneyByRAid(int money,int raid);
    List<RAP> getRAPByEidLastMonth(int eid,int state);//找出上个月某人的全部记录
    List<RAP> getRAPByEidAndStateLastMonth(int eid,int state);
    List<RAP> getAllRAPByEid(int eid);
    List<RAP> getAllRAPByEidAndPage(int eid,int begin,int end);
}
