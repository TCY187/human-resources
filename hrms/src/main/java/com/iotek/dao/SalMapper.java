package com.iotek.dao;

import com.iotek.model.Sal;

import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
public interface SalMapper {
    boolean saveSal(Sal sal);
    List<Sal> getSalByMonth();//�ҳ��������ɵ�ȫ��������
    List<Sal> getSalByMonthAndPage(int begin,int end);//�ҳ��������ɵ�ȫ��������
    Sal getSalByEidAndMonth(int eid);
    Sal getSalBySid(int sid);
    List<Sal> getSalByState(int state);
    List<Sal> getSalByStateAndPage(int state,int begin,int end);
    boolean updateSal(Sal sal);//����
}
