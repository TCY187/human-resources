package com.iotek.controller;

import com.iotek.model.Emp;
import com.iotek.model.Position;
import com.iotek.service.EmpService;
import com.iotek.service.PositionService;
import com.iotek.service.RecrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
@Controller
public class PositionController {
    @Resource
    private RecrService recrService;
    @Resource
    private EmpService empService;
    @Resource
    private PositionService positionService;
    @RequestMapping("/getPositionByDepa")
    public String getPositionByDepa(int did1, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        List<Position> positionList = positionService.getPositionByDid(did1);
        int totalNum=positionList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Position> positionList1 = positionService.getPositionByDidAndPage(did1,begin,end);
        session.setAttribute("positionList",positionList1);
        session.setAttribute("ptotalPages",totalPages);
        session.setAttribute("did",did1);
        return "operatePosition";
    }
    @RequestMapping("/empgetPositionByDepa")
    public String empgetPositionByDepa(int did1, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        List<Position> positionList = positionService.getPositionByDid(did1);
        int totalNum=positionList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Position> positionList1 = positionService.getPositionByDidAndPage(did1,begin,end);
        session.setAttribute("emppositionList",positionList1);
        session.setAttribute("empptotalPages",totalPages);
        return "empListPosition";
    }
    @RequestMapping("/deletePosition")
    public String deletePosition(int pid1, Model model, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        List<Emp> empList = empService.getEmpByPosition(pid1);
        if(empList.size()==0){
            boolean flag = positionService.deletePosition(pid1);
            boolean flag1 = recrService.deleteRecrByPid(pid1);
            int did1 = Integer.parseInt((String)session.getAttribute("did"));
            List<Position> positionList = positionService.getPositionByDid(did1);
            int totalNum=positionList.size();
            int pageSize=5;
            int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
            int begin = (currentPage-1)*pageSize+1;
            int end = (currentPage-1)*pageSize+pageSize;
            List<Position> positionList1 = positionService.getPositionByDidAndPage(did1,begin,end);
            session.setAttribute("positionList",positionList1);
            session.setAttribute("ptotalPages",totalPages);
            session.setAttribute("did",did1);
            return "operatePosition";
        }
        model.addAttribute("operatePerror","²»¿ÉÉ¾³ý");
        return "operatePosition";
    }
}
