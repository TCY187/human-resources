package com.iotek.service;

import com.iotek.model.CV;
import com.iotek.model.User;

import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
public interface CVService {
    List<CV> getCVByUid(User user);
}
