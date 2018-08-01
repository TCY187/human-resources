package com.iotek.dao;

import com.iotek.model.Emp;

import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
public interface EmpMapper {
    boolean saveEmp(Emp emp);
    List<Emp> getEmpByDepa(int did);
    List<Emp> getEmpByDepaAndPage(int pid,int begin,int end);
    boolean deleteEmp(int id);
    boolean updateEmp(Emp emp);
    List<Emp> getEmpByPosition(int pid);
    List<Emp> getEmpByPositionAndPage(int pid,int begin,int end);
}
