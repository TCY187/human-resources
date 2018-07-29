package com.iotek.service.impl;

import com.iotek.dao.InterviewMapper;
import com.iotek.model.Interview;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TCY on 2018/7/29.
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewMapper interviewMapper;

    public boolean saveInterview(Interview interview) {
        return interviewMapper.saveInterview(interview);
    }

    public List<Interview> getInterviewByState(int state) {
        return interviewMapper.getInterviewByState(state);
    }

    public List<Interview> getInterviewByStateAndPage(int state, int begin, int end) {
        return interviewMapper.getInterviewByStateAndPage(state, begin, end);
    }

    public List<Interview> getInterviewByStateAndUid(int state, int uid) {
        return interviewMapper.getInterviewByStateAndUid(state, uid);
    }

    public List<Interview> getInterviewByStateAndUidAndPage(int state, int uid, int begin, int end) {
        return interviewMapper.getInterviewByStateAndUidAndPage(state, uid, begin, end);
    }
}
