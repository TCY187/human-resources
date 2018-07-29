package com.iotek.service.impl;

import com.iotek.dao.GetCVMapper;
import com.iotek.model.CV;
import com.iotek.model.GetCV;
import com.iotek.service.GetCVService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
@Service
public class GetCVServiceImpl implements GetCVService{
    @Resource
    private GetCVMapper getCVMapper;

    public boolean saveGetCV(int cvid,int rid) {
        return getCVMapper.saveGetCV(cvid, rid);
    }

    public List<GetCV> getGetCVByState(int state) {
        return getCVMapper.getGetCVByState(state);
    }

    public List<GetCV> getGetCVByStateAndPage(int state, int begin, int end) {
        return getCVMapper.getGetCVByStateAndPage(state, begin, end);
    }

    public GetCV getGetCVById(int id) {
        return getCVMapper.getGetCVById(id);
    }

    public boolean updateGetCVByState(GetCV getCV) {
        return getCVMapper.updateGetCVByState(getCV);
    }
}
