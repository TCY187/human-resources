package com.iotek.controller;

import com.iotek.model.CV;
import com.iotek.model.GetCV;
import com.iotek.model.Interview;
import com.iotek.model.Recr;
import com.iotek.service.CVService;
import com.iotek.service.GetCVService;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
@Controller
public class GetCVController {
    @Resource
    private InterviewService interviewService;
    @Resource
    private CVService cvService;
    @Resource
    private GetCVService getCVService;
    @RequestMapping("/sendCV")
    public String sendCV(int CVDId1, HttpSession session){
        Recr recr = (Recr) session.getAttribute("recr");
        CV cv = cvService.getCVByCVid(CVDId1);
        boolean flag = getCVService.saveGetCV(cv.getId(),recr.getId());
        return "../../login";
    }
    @RequestMapping("/getGetCV")
    public String getGetCV(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session){
        int state = 0;
        List<GetCV> getCVList = getCVService.getGetCVByState(state);
        int totalNum=getCVList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<GetCV> getCVList1 = getCVService.getGetCVByStateAndPage(state,begin,end);
        session.setAttribute("GCVtotalPages",totalPages);
        session.setAttribute("getCVList",getCVList1);
        return "listGetCV";
    }
    @RequestMapping("/miansi")
    public String miansi(int gid1,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session){
        GetCV getCV = getCVService.getGetCVById(gid1);
        getCV.setState(1);
        Interview interview = new Interview();
        interview.setUser(getCV.getCv().getUser());
        interview.setRecr(getCV.getRecr());
        interview.setAddress(getCV.getRecr().getDepa().getDname());
        interview.setState(0);
        interview.setRemarks("нч");
        interview.setCv(getCV.getCv());
        System.out.println(interview);
        boolean flag1 = interviewService.saveInterview(interview);
        boolean flag = getCVService.updateGetCVByState(getCV);
        int state = 0;
        List<GetCV> getCVList = getCVService.getGetCVByState(state);
        int totalNum=getCVList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<GetCV> getCVList1 = getCVService.getGetCVByStateAndPage(state,begin,end);
        session.setAttribute("GCVtotalPages",totalPages);
        session.setAttribute("getCVList",getCVList1);
        return "listGetCV";
    }
    @RequestMapping("/buheshi")
    public String buheshi(int gid2,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session){
        GetCV getCV = getCVService.getGetCVById(gid2);
        getCV.setState(2);
        boolean flag = getCVService.updateGetCVByState(getCV);
        int state = 0;
        List<GetCV> getCVList = getCVService.getGetCVByState(state);
        int totalNum=getCVList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<GetCV> getCVList1 = getCVService.getGetCVByStateAndPage(state,begin,end);
        session.setAttribute("GCVtotalPages",totalPages);
        session.setAttribute("getCVList",getCVList1);
        return "listGetCV";
    }
}
