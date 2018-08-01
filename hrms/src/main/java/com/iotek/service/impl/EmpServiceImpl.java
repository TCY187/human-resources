package com.iotek.service.impl;

import com.iotek.dao.EmpMapper;
import com.iotek.model.Emp;
import com.iotek.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
