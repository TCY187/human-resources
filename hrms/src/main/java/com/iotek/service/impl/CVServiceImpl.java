package com.iotek.service.impl;

import com.iotek.dao.CVMapper;
import com.iotek.model.CV;
import com.iotek.model.User;
import com.iotek.service.CVService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
@Service
public class CVServiceImpl implements CVService {
    @Resource
    private CVMapper cvMapper;

    public List<CV> getCVByUid(User user) {
        return cvMapper.getCVByUid(user);
    }
}
