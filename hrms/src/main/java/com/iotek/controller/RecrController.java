package com.iotek.controller;

import com.iotek.model.Depa;
import com.iotek.model.Emp;
import com.iotek.model.Position;
import com.iotek.model.Recr;
import com.iotek.service.DepaService;
import com.iotek.service.PositionService;
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
    private DepaService depaService;
    @Resource
    private PositionService positionService;
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
        List<Recr> recrList = recrService.getRecrByState(1);//查看已发布的
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(1,begin,end);
        session.setAttribute("manrecrList",recrList1);
        session.setAttribute("mantotalPages",totalPages);
        return "listmanRecr";
    }
    @RequestMapping("/getRecr0")
    public String getRecr0(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        List<Recr> recrList = recrService.getRecrByState(0);//查看未发布的
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(0,begin,end);
        session.setAttribute("recr0List",recrList1);
        session.setAttribute("recr0totalPages",totalPages);
        return "listRecr0";//未发布
    }
    @RequestMapping("/deleteRecr")
    public String deleteRecr(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,int rid2){
        boolean flag = recrService.deleteRecrByRid(rid2);
        List<Recr> recrList = recrService.getRecrByState(0);//查看未发布的
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(0,begin,end);
        session.setAttribute("recr0List",recrList1);
        session.setAttribute("recr0totalPages",totalPages);
        return "listRecr0";//未发布
    }
    @RequestMapping("/addRecr1")
    public String addRecr1(int selectDep,int selectPosition,HttpSession session){
        Depa depa = depaService.getDepaByDid(selectDep);
        Position position  = positionService.getPositionByPid(selectPosition);
        session.setAttribute("addRecrPosition",position);
        session.setAttribute("addRecrDepa",depa);
        return "addRecr1";
    }
    @RequestMapping("/addRecr2")
    public String addRecr2(HttpSession session,Recr recr,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage){
        Depa depa = (Depa) session.getAttribute("addRecrDepa");
        Position position  = (Position) session.getAttribute("addRecrPosition");
        recr.setDepa(depa);
        recr.setPosition(position);
        recr.setState(0);
        recrService.saveRecr(recr);
        List<Recr> recrList = recrService.getRecrByState(0);//查看非发布的
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(0,begin,end);
        session.setAttribute("recr0List",recrList1);
        session.setAttribute("recr0totalPages",totalPages);
        return "listRecr0";//未发布
    }
    @RequestMapping("/issueRecr")
    public String issueRecr(HttpSession session,int rid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage){
        Recr recr = recrService.getRecrByRid(rid);
        recr.setState(1);
        recrService.updateRecr(recr);
        List<Recr> recrList = recrService.getRecrByState(0);//查看非发布的
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(0,begin,end);
        session.setAttribute("recr0List",recrList1);
        session.setAttribute("recr0totalPages",totalPages);
        return "listRecr0";//未发布
    }
    @RequestMapping("/recallRecr")
    public String recallRecr(HttpSession session,int rid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage){
        Recr recr = recrService.getRecrByRid(rid);
        recr.setState(0);
        recrService.updateRecr(recr);
        List<Recr> recrList = recrService.getRecrByState(1);//查看非发布的
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(1,begin,end);
        session.setAttribute("manrecrList",recrList1);
        session.setAttribute("mantotalPages",totalPages);
        return "listmanRecr";
    }
    @RequestMapping("/updateRecr")
    public String updateRecr(HttpSession session,int rid1){
        Recr recr = recrService.getRecrByRid(rid1);
        session.setAttribute("updateRecr",recr);
        return "updateRecr";
    }
    @RequestMapping("/updateRecr1")
    public String updateRecr1(HttpSession session,Recr recr,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage){
        Recr recr1 = (Recr) session.getAttribute("updateRecr");
        recr1.setDesc(recr.getDesc());
        recr1.setNum(recr.getNum());
        recrService.updateRecr(recr1);
        List<Recr> recrList = recrService.getRecrByState(0);//查看非发布的
        int totalNum=recrList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recr> recrList1 = recrService.getRecrByStateAndPage(0,begin,end);
        session.setAttribute("recr0List",recrList1);
        session.setAttribute("recr0totalPages",totalPages);
        return "listRecr0";//未发布
    }
}
