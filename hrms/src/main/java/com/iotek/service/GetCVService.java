package com.iotek.service;

import com.iotek.model.CV;
import com.iotek.model.GetCV;

import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
public interface GetCVService {
    boolean saveGetCV(int cvid,int rid);
    List<GetCV> getGetCVByState(int state);
    List<GetCV> getGetCVByStateAndPage(int state,int begin,int end);
    GetCV getGetCVById(int id);
    boolean updateGetCVByState(GetCV getCV);
}
