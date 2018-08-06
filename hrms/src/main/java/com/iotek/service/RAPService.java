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
    RAP getRAPByEidAndSateAndSysdate(int eid,int state);//���ҵ���ĳ״̬�ļ�¼
    boolean deleteRAPByRAid(int raid);
    RAP getRAPByRAid(int raid);
    boolean updateRAPMoneyByRAid(int money,int raid);
    List<RAP> getRAPByEidLastMonth(int eid,int state);//�ҳ��ϸ���ĳ�˵�ȫ����¼
    List<RAP> getRAPByEidAndStateLastMonth(int eid,int state);
    List<RAP> getAllRAPByEid(int eid);
    List<RAP> getAllRAPByEidAndPage(int eid,int begin,int end);
}
