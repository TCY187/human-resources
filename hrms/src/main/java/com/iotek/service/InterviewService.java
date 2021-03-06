package com.iotek.service;

import com.iotek.model.Interview;

import java.util.List;

/**
 * Created by TCY on 2018/7/29.
 */
public interface InterviewService {
    boolean saveInterview(Interview interview);
    List<Interview> getInterviewByState(int state);
    List<Interview> getInterviewByStateAndPage(int state,int begin,int end);
    List<Interview> getInterviewByStateAndUid(int state,int uid);
    List<Interview> getInterviewByStateAndUidAndPage(int state,int uid,int begin,int end);
    boolean updateIntState(Interview interview);
    Interview getIntById(int IId);
}
