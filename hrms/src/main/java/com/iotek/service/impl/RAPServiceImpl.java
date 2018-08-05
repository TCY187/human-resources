package com.iotek.service.impl;

import com.iotek.dao.RAPMapper;
import com.iotek.model.RAP;
import com.iotek.service.RAPService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
@Service
public class RAPServiceImpl implements RAPService {
    @Resource
    private RAPMapper rapMapper;

    public boolean saveRAP(RAP rap) {
        return rapMapper.saveRAP(rap);
    }

    public List<RAP> getRAPByEid(int eid) {
        return rapMapper.getRAPByEid(eid);
    }

    public List<RAP> getRAPByEidAndPage(int eid, int begin, int end) {
        return rapMapper.getRAPByEidAndPage(eid, begin, end);
    }

    public RAP getRAPByEidAndSateAndSysdate(int eid, int state) {
        return rapMapper.getRAPByEidAndSateAndSysdate(eid, state);
    }

    public boolean deleteRAPByRAid(int raid) {
        return rapMapper.deleteRAPByRAid(raid);
    }

    public RAP getRAPByRAid(int raid) {
        return rapMapper.getRAPByRAid(raid);
    }

    public boolean updateRAPMoneyByRAid(int money, int raid) {
        return rapMapper.updateRAPMoneyByRAid(money, raid);
    }

    public List<RAP> getRAPByEidLastMonth(int eid,int state) {
        return rapMapper.getRAPByEidLastMonth(eid,state);
    }

    public List<RAP> getRAPByEidAndStateLastMonth(int eid, int state) {
        return rapMapper.getRAPByEidAndStateLastMonth(eid, state);
    }
}
