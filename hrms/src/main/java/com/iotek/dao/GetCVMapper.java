package com.iotek.dao;

import com.iotek.model.CV;
import com.iotek.model.GetCV;
import org.apache.ibatis.annotations.Param;

/**
 * Created by TCY on 2018/7/26.
 */
public interface GetCVMapper {
    boolean saveGetCV(int cvid,int rid);
}
