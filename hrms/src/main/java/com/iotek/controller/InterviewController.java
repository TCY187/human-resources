package com.iotek.controller;

import com.iotek.model.Emp;
import com.iotek.model.GetCV;
import com.iotek.model.Interview;
import com.iotek.model.User;
import com.iotek.service.EmpService;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private EmpService empService;
    @Resource
    private InterviewService interviewService;
    @RequestMapping("/getuserInt")
    public String getuserInt(Model model, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null){
            model.addAttribute("clogerror","ÇëÏÈµÇÂ¼");
            return "../../login";
        }
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
        Emp emp = new Emp();
        emp.setUname(interview.getCv().getUname());
        emp.setSex(interview.getCv().getSex());
        emp.setBirth(interview.getCv().getBirth());
        emp.setBp(interview.getCv().getBp());
        emp.setEdu(interview.getCv().getEdu());
        emp.setMajor(interview.getCv().getMajor());
        emp.setEmail(interview.getCv().getEmail());
        emp.setPhone(interview.getCv().getPhone());
        emp.setSchool(interview.getCv().getSchool());
        emp.setCardno(interview.getCv().getCardno());
        emp.setDepa(interview.getRecr().getDepa());
        emp.setPosition(interview.getRecr().getPosition());
        emp.setState(0);
        empService.saveEmp(emp);
        System.out.println("++++++++++++++++"+emp);
        Emp emp1 = empService.getEmpByEid(emp.getId());
        emp1.setEname("T"+emp1.getId());
        emp1.setPass("T"+emp1.getId());
        System.out.println("++++++++++++++++"+emp1);
        empService.updateEmpNP(emp1);
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
