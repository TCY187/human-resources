package com.iotek.service;

import com.iotek.model.CV;
import com.iotek.model.User;

import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
public interface CVService {
    List<CV> getCVByUid(int uid);
    List<CV> getCVByUidAndPage(int uid,int begin,int end);
    CV getCVByCVid(int CVid);
    boolean deleteCVByCVid(int CVid);
    boolean saveCV(CV cv);
}
