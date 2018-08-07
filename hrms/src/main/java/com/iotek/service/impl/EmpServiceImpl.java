package com.iotek.service.impl;

import com.iotek.dao.EmpMapper;
import com.iotek.model.Emp;
import com.iotek.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
@Service
public class EmpServiceImpl implements EmpService{
    @Resource
    private EmpMapper empMapper;

    public boolean saveEmp(Emp emp) {
        return empMapper.saveEmp(emp);
    }

    public List<Emp> getEmpByDepa(int did) {
        return empMapper.getEmpByDepa(did);
    }

    public List<Emp> getEmpByDepaAndPage(int did, int begin, int end) {
        return empMapper.getEmpByDepaAndPage(did, begin, end);
    }

    public boolean deleteEmp(int id) {
        return empMapper.deleteEmp(id);
    }

    public boolean updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    public List<Emp> getEmpByPosition(int pid) {
        return empMapper.getEmpByPosition(pid);
    }

    public List<Emp> getEmpByPositionAndPage(int pid, int begin, int end) {
        return empMapper.getEmpByPositionAndPage(pid, begin, end);
    }

    public boolean updateQuitEmp(int id,String quit) {
        return empMapper.updateQuitEmp(id,quit);
    }

    public List<Emp> getAllEmp() {
        return empMapper.getAllEmp();
    }

    public Emp getEmpByPass(Emp emp) {
        return empMapper.getEmpByPass(emp);
    }

    public List<Emp> getEmpByState(int state) {
        return empMapper.getEmpByState(state);
    }

    public List<Emp> getEmpByStateAndPage(int state, int begin, int end) {
        return empMapper.getEmpByStateAndPage(state, begin, end);
    }

    public Emp getEmpByEid(int eid) {
        return empMapper.getEmpByEid(eid);
    }

    public boolean updateEmpState(Emp emp) {
        return empMapper.updateEmpState(emp);
    }

    public boolean updateEmpDP(Emp emp) {
        return empMapper.updateEmpDP(emp);
    }

    public boolean updateEmpNP(Emp emp) {
        return empMapper.updateEmpNP(emp);
    }
}
