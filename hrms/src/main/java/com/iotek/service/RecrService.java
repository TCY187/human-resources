package com.iotek.service;

import com.iotek.model.Recr;

import java.util.List;

/**
 * Created by TCY on 2018/7/25.
 */
public interface RecrService {
    List<Recr> getRecrByStateAndPage(int state,int begin,int end);
    List<Recr> getRecrByState(int state);
    Recr getRecrByRid(int rid);
    List<Recr> getRecrByPage(int begin,int end);
    List<Recr> getRecr();
    boolean deleteRecrByRid(int rid);
    boolean deleteRecrByDid(int did);
    boolean deleteRecrByPid(int pid);
    List<Integer> getRidByDid(int did);
    boolean saveRecr(Recr recr);
    boolean updateRecr(Recr recr);//�޸�״̬
}
