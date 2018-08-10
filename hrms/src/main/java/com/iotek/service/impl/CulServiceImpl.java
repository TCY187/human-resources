package com.iotek.service.impl;

import com.iotek.dao.CulMapper;
import com.iotek.dao.ECMapper;
import com.iotek.model.Cul;
import com.iotek.service.CulService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/8/2.
 */
@Service
public class CulServiceImpl implements CulService {
    @Resource
    private ECMapper ecMapper;
    @Resource
    private CulMapper culMapper;

    public List<Cul> getCulByState(int state) {
        return culMapper.getCulByState(state);
    }

    public List<Cul> getCulByStateAndPage(int state, int begin, int end) {
        return culMapper.getCulByStateAndPage(state, begin, end);
    }

    public boolean saveCul(Cul cul) {
        return culMapper.saveCul(cul);
    }

    public boolean saveEC(int eid, int cid) {
        return ecMapper.saveEC(eid, cid);
    }

    public boolean updateCulStateByCid(int state, Date issuetime,int cid) {
        return culMapper.updateCulStateByCid(state,issuetime, cid);
    }

    public Cul getCulByCid(int cid) {
        return culMapper.getCulByCid(cid);
    }

    public boolean deleteCulByCid(int cid) {
        return culMapper.deleteCulByCid(cid);
    }

    public boolean deleteECByCid(int cid) {
        return ecMapper.deleteECByCid(cid);
    }

    public boolean updateCulByCid(Cul cul) {
        return culMapper.updateCulByCid(cul);
    }

    public List<Cul> getCulByEidAndState(int eid,int state) {
        return culMapper.getCulByEidAndState(eid,state);
    }

    public boolean updateCulStateByCid1(int state, int cid) {
        return culMapper.updateCulStateByCid1(state, cid);
    }
}
