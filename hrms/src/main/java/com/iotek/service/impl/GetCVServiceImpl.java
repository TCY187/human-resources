package com.iotek.service.impl;

import com.iotek.dao.GetCVMapper;
import com.iotek.model.CV;
import com.iotek.model.GetCV;
import com.iotek.service.GetCVService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
