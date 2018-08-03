package com.iotek.controller;

import com.iotek.model.Attendance;
import com.iotek.model.Emp;
import com.iotek.model.RAP;
import com.iotek.service.RAPService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
@Controller
public class RAPController {
    @Resource
    private RAPService rapService;
    @RequestMapping("/getRAPByEid")
    public String getRAPByEid(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        Emp emp  = (Emp) session.getAttribute("emp");
        List<RAP> rapList = rapService.getRAPByEid(emp.getId());
        int totalNum=rapList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<RAP> rapList1 = rapService.getRAPByEidAndPage(emp.getId(),begin,end);
        session.setAttribute("rapList",rapList1);
        session.setAttribute("raptotalPages",totalPages);
        return "listRAP";
    }
}
