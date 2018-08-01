package com.iotek.controller;

import com.iotek.model.Emp;
import com.iotek.service.EmpService;
import org.springframework.stereotype.Controller;
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
    public String getEmpByDepa(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, int did, HttpSession session){
        List<Emp> empList = empService.getEmpByDepa(did);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1 = empService.getEmpByDepaAndPage(did,begin,end);
        session.setAttribute("empList",empList1);
        session.setAttribute("emptotalPages",totalPages);
        return "listEmp";
    }
}
