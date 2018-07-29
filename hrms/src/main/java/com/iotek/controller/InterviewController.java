package com.iotek.controller;

import com.iotek.model.GetCV;
import com.iotek.model.Interview;
import com.iotek.model.User;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by TCY on 2018/7/30.
 */
@Controller
public class InterviewController {
    @Resource
    private InterviewService interviewService;
    @RequestMapping("/getuserInt")
    public String getuserInt(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        User user = (User) session.getAttribute("user");
        int state = 0;
        List<Interview> interviewList = interviewService.getInterviewByStateAndUid(state,user.getId());
        int totalNum=interviewList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviewList1 = interviewService.getInterviewByStateAndUidAndPage(state,user.getId(),begin,end);
        session.setAttribute("intGCVtotalPages",totalPages);
        session.setAttribute("interviewList",interviewList1);
        return "listInterview";
    }
    @RequestMapping("/acceptInt")
    public String acceptInt(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,int iid1){
        Interview interview = interviewService.getIntById(iid1);
        interview.setState(1);
        boolean flag = interviewService.updateIntState(interview);
        User user = (User) session.getAttribute("user");
        int state = 0;
        List<Interview> interviewList = interviewService.getInterviewByStateAndUid(state,user.getId());
        int totalNum=interviewList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviewList1 = interviewService.getInterviewByStateAndUidAndPage(state,user.getId(),begin,end);
        session.setAttribute("intGCVtotalPages",totalPages);
        session.setAttribute("interviewList",interviewList1);
        return "listInterview";
    }
    @RequestMapping("/unacceptInt")
    public String unacceptInt(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,int iid2){
        Interview interview = interviewService.getIntById(iid2);
        interview.setState(2);
        boolean flag = interviewService.updateIntState(interview);
        User user = (User) session.getAttribute("user");
        int state = 0;
        List<Interview> interviewList = interviewService.getInterviewByStateAndUid(state,user.getId());
        int totalNum=interviewList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviewList1 = interviewService.getInterviewByStateAndUidAndPage(state,user.getId(),begin,end);
        session.setAttribute("intGCVtotalPages",totalPages);
        session.setAttribute("interviewList",interviewList1);
        return "listInterview";
    }
    @RequestMapping("/getmanInt")
    public String getmanInt(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        int state = 1;
        List<Interview> interviewList = interviewService.getInterviewByState(state);
        int totalNum=interviewList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviewList1 = interviewService.getInterviewByStateAndPage(state,begin,end);
        session.setAttribute("inttotalPages",totalPages);
        session.setAttribute("maninterviewList",interviewList1);
        return "listmanInterview";
    }
    @RequestMapping("/hireInt")
    public String hireInt(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,int iid3){
        Interview interview = interviewService.getIntById(iid3);
        interview.setState(3);
        boolean flag = interviewService.updateIntState(interview);
        int state = 1;
        List<Interview> interviewList = interviewService.getInterviewByState(state);
        int totalNum=interviewList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviewList1 = interviewService.getInterviewByStateAndPage(state,begin,end);
        session.setAttribute("inttotalPages",totalPages);
        session.setAttribute("maninterviewList",interviewList1);
        return "listmanInterview";
    }
    @RequestMapping("/unhireInt")
    public String unhireInt(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,int iid4){
        Interview interview = interviewService.getIntById(iid4);
        interview.setState(4);
        boolean flag = interviewService.updateIntState(interview);
        int state = 1;
        List<Interview> interviewList = interviewService.getInterviewByState(state);
        int totalNum=interviewList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviewList1 = interviewService.getInterviewByStateAndPage(state,begin,end);
        session.setAttribute("inttotalPages",totalPages);
        session.setAttribute("maninterviewList",interviewList1);
        return "listmanInterview";
    }
}
