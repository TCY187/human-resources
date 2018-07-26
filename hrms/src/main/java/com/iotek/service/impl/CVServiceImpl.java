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

    public List<CV> getCVByUid(int uid) {
        return cvMapper.getCVByUid(uid);
    }

    public List<CV> getCVByUidAndPage(int uid, int begin, int end) {
        return cvMapper.getCVByUidAndPage(uid,begin,end);
    }

    public CV getCVByCVid(int CVid) {
        return cvMapper.getCVByCVid(CVid);
    }

    public boolean deleteCVByCVid(int CVid) {
        return cvMapper.deleteCVByCVid(CVid);
    }

    public boolean saveCV(CV cv) {
        return cvMapper.saveCV(cv);
    }
}
