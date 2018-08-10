package com.iotek.service.impl;

import com.iotek.dao.SalMapper;
import com.iotek.model.Sal;
import com.iotek.service.SalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
@Service
public class SalServiceImpl implements SalService{
    @Resource
    private SalMapper salMapper;

    public boolean saveSal(Sal sal) {
        return salMapper.saveSal(sal);
    }

    public List<Sal> getSalByMonth() {
        return salMapper.getSalByMonth();
    }

    public Sal getSalByEidAndMonth(int eid) {
        return salMapper.getSalByEidAndMonth(eid);
    }

    public List<Sal> getSalByMonthAndPage(int begin, int end) {
        return salMapper.getSalByMonthAndPage(begin, end);
    }

    public Sal getSalBySid(int sid) {
        return salMapper.getSalBySid(sid);
    }

    public List<Sal> getSalByState(int state) {
        return salMapper.getSalByState(state);
    }

    public List<Sal> getSalByStateAndPage(int state, int begin, int end) {
        return salMapper.getSalByStateAndPage(state, begin, end);
    }

    public boolean updateSal(Sal sal) {
        return salMapper.updateSal(sal);
    }
}
