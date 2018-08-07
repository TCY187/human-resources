package com.iotek.service;

import com.iotek.model.Emp;

import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
public interface EmpService {
    boolean saveEmp(Emp emp);
    List<Emp> getEmpByDepa(int did);
    List<Emp> getEmpByDepaAndPage(int did,int begin,int end);
    boolean deleteEmp(int id);
    boolean updateEmp(Emp emp);
    List<Emp> getEmpByPosition(int pid);
    List<Emp> getEmpByPositionAndPage(int pid,int begin,int end);
    boolean updateQuitEmp(int id,String quit);
    List<Emp> getAllEmp();
    Emp getEmpByPass(Emp emp);
    List<Emp> getEmpByState(int state);
    List<Emp> getEmpByStateAndPage(int state,int begin,int end);
    Emp getEmpByEid(int eid);
    boolean updateEmpState(Emp emp);
    boolean updateEmpDP(Emp emp);
    boolean updateEmpNP(Emp emp);//≈…∑¢’À∫≈√‹¬Î
}
