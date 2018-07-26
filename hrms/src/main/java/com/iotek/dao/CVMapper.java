package com.iotek.dao;

import com.iotek.model.CV;
import com.iotek.model.User;

import java.util.List;

/**
 * Created by TCY on 2018/7/25.
 */
public interface CVMapper {
    List<CV> getCVByUid(User user);
}
