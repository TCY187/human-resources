package com.iotek.dao;

import com.iotek.model.Recr;

import java.util.List;

/**
 * Created by TCY on 2018/7/25.
 */
public interface RecrMapper {
    List<Recr> getRecrByStateAndPage(int state,int begin,int end);
    List<Recr> getRecrByState(int state);
    Recr getRecrByRid(int rid);
}
