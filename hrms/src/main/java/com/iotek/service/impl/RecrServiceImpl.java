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

    public List<Recr> getRecrByPage(int begin, int end) {
        return recrMapper.getRecrByPage(begin, end);
    }

    public List<Recr> getRecr() {
        return recrMapper.getRecr();
    }

    public boolean deleteRecrByRid(int rid) {
        return recrMapper.deleteRecrByRid(rid);
    }

    public List<Integer> getRidByDid(int did) {
        return recrMapper.getRidByDid(did);
    }

    public boolean deleteRecrByDid(int did) {
        return recrMapper.deleteRecrByDid(did);
    }

    public boolean deleteRecrByPid(int pid) {
        return recrMapper.deleteRecrByPid(pid);
    }
}
