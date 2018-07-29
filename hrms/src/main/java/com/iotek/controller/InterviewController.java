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
}
