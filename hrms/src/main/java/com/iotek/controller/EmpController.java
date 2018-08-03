package com.iotek.controller;

import com.iotek.model.Emp;
import com.iotek.service.EmpService;
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
public class EmpController {
    @Resource
    private EmpService empService;
    @RequestMapping("/getEmpByDepa")
    public String getEmpByDepa(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, int did3, HttpSession session){
        List<Emp> empList = empService.getEmpByDepa(did3);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1 = empService.getEmpByDepaAndPage(did3,begin,end);
        session.setAttribute("empdepaList",empList1);
        session.setAttribute("empdepatotalPages",totalPages);
        return "listDepaEmp";
    }
    @RequestMapping("/getEmpByPosition")
    public String getEmpByPosition(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, int pid2, HttpSession session){
        List<Emp> empList = empService.getEmpByPosition(pid2);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1= empService.getEmpByPositionAndPage(pid2,begin,end);
        session.setAttribute("emppList",empList1);
        session.setAttribute("empptotalPages",totalPages);
        session.setAttribute("pid2",pid2+"");
        return "listPEmp";
    }
    @RequestMapping("/quit")
    public String quit(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,int eid){
        boolean flag = empService.updateQuitEmp(eid);
        int pid2 =Integer.parseInt((String) session.getAttribute("pid2"));
        List<Emp> empList = empService.getEmpByPosition(pid2);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1= empService.getEmpByPositionAndPage(pid2,begin,end);
        session.setAttribute("emppList",empList1);
        session.setAttribute("empptotalPages",totalPages);
        return "listPEmp";
    }
    @RequestMapping("/emplogin")
    public String emplogin(Emp emp, HttpSession session, Model model){
        System.out.println(emp);
        Emp emp1 = empService.getEmpByPass(emp);
        if(emp1!=null){
            session.setAttribute("emp",emp1);
            return "empSuccess";
        }
        model.addAttribute("emplogerror","µÇÂ¼Ãû»òÃÜÂë´íÎó");
        return "../../login";
    }
}
