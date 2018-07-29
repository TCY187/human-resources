package com.iotek.dao;

import com.iotek.model.CV;
import com.iotek.model.GetCV;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
public interface GetCVMapper {
    boolean saveGetCV(int cvid,int rid);
    List<GetCV> getGetCVByState(int state);
    List<GetCV> getGetCVByStateAndPage(int state,int begin,int end);
    GetCV getGetCVById(int id);
    boolean updateGetCVByState(GetCV getCV);
}
