package com.iotek.service.impl;

import com.iotek.dao.RecrMapper;
import com.iotek.model.Recr;
import com.iotek.service.RecrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/7/25.
 */
@Service
public class RecrServiceImpl implements RecrService{
    @Resource
    private RecrMapper recrMapper;

    public List<Recr> getRecrByState(int state) {
        return recrMapper.getRecrByState(state);
    }
    public List<Recr> getRecrByStateAndPage(int state, int begin, int end) {
        return recrMapper.getRecrByStateAndPage(state, begin, end);
    }

    public Recr getRecrByRid(int rid) {
        return recrMapper.getRecrByRid(rid);
    }
}
