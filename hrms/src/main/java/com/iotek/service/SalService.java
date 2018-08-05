package com.iotek.service;

import com.iotek.model.Sal;

import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
public interface SalService {
    boolean saveSal(Sal sal);
    List<Sal> getSalByMonth();//找出当月生成的全部工资条
    List<Sal> getSalByMonthAndPage(int begin,int end);//找出当月生成的全部工资条
    Sal getSalByEidAndMonth(int eid);
}
