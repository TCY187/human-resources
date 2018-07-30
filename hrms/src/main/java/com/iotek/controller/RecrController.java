package com.iotek.controller;

import com.iotek.model.Recr;
import com.iotek.service.RecrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by TCY on 2018/7/25.
 */
@Controller
public class RecrController {
    @Resource
    private RecrService recrService;
    @RequestMapping("/")
    public String listRecr(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        int state = 1;
        List<Recr> recrList = recrService.getRecrByState(state);
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(state,begin,end);
        System.out.println(recrList1);
        session.setAttribute("recrList",recrList1);
        session.setAttribute("totalPages",totalPages);
        return "../../login";
    }
    @RequestMapping("/getRecr")
    public String getRecr(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        List<Recr> recrList = recrService.getRecr();
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByPage(begin,end);
        session.setAttribute("manrecrList",recrList1);
        session.setAttribute("mantotalPages",totalPages);
        return "listmanRecr";
    }
    @RequestMapping("/deleteRecr")
    public String deleteRecr(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,int rid){
        boolean flag = recrService.deleteRecrByRid(rid);
        List<Recr> recrList = recrService.getRecr();
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByPage(begin,end);
        session.setAttribute("manrecrList",recrList1);
        session.setAttribute("mantotalPages",totalPages);
        return "listmanRecr";
    }
}
