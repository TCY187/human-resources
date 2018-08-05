package com.iotek.controller;

import com.iotek.model.Attendance;
import com.iotek.model.Emp;
import com.iotek.model.RAP;
import com.iotek.service.EmpService;
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
    @RequestMapping("/MgetRAPByEmp")
    public String MgetRAPByEmp(int eid1,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        List<RAP> rapList = rapService.getRAPByEid(eid1);
        int totalNum=rapList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<RAP> rapList1 = rapService.getRAPByEidAndPage(eid1,begin,end);
        session.setAttribute("Meid",eid1+"");
        session.setAttribute("MrapList",rapList1);
        session.setAttribute("MraptotalPages",totalPages);
        return "MlistRAP";
    }
    @RequestMapping("/deleteRAP")
    public String deleteRAP(int raid1,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        rapService.deleteRAPByRAid(raid1);
        int eid1 =Integer.parseInt((String) session.getAttribute("Meid"));
        List<RAP> rapList = rapService.getRAPByEid(eid1);
        int totalNum=rapList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<RAP> rapList1 = rapService.getRAPByEidAndPage(eid1,begin,end);
        session.setAttribute("MrapList",rapList1);
        session.setAttribute("MraptotalPages",totalPages);
        return "MlistRAP";
    }
    @RequestMapping("/updateRAP")
    public String updateRAP(int raid2,HttpSession session){
        RAP rap = rapService.getRAPByRAid(raid2);
        session.setAttribute("Mrap",rap);
        return "updateRAP";
    }
    @RequestMapping("/updateRAP1")
    public String updateRAP1(int updateMoney,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        RAP rap = (RAP)session.getAttribute("Mrap");
        rapService.updateRAPMoneyByRAid(updateMoney,rap.getId());
        int eid1 =Integer.parseInt((String) session.getAttribute("Meid"));
        List<RAP> rapList = rapService.getRAPByEid(eid1);
        int totalNum=rapList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<RAP> rapList1 = rapService.getRAPByEidAndPage(eid1,begin,end);
        session.setAttribute("MrapList",rapList1);
        session.setAttribute("MraptotalPages",totalPages);
        return "MlistRAP";
    }
    @RequestMapping("/saveRAP")
    public String saveRAP(){
        return "addRAP";
    }
    @RequestMapping("/saveRAP1")
    public String saveRAP1(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,String intro,double money,HttpSession session){
        int state = 0;
        if(intro.equals("Ω·À„¥ÌŒÛ")){
            state = 3;
        }
        if(intro.equals("∆‰À˚")){
            state = 4;
        }
        int eid1 =Integer.parseInt((String) session.getAttribute("Meid"));
        RAP rap = new RAP();
        Emp emp = new Emp();
        emp.setId(eid1);
        rap.setIntro(intro);
        rap.setMoney(money);
        rap.setEmp(emp);
        rap.setState(state);
        rapService.saveRAP(rap);
        List<RAP> rapList = rapService.getRAPByEid(eid1);
        int totalNum=rapList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<RAP> rapList1 = rapService.getRAPByEidAndPage(eid1,begin,end);
        session.setAttribute("MrapList",rapList1);
        session.setAttribute("MraptotalPages",totalPages);
        return "MlistRAP";
    }

}
