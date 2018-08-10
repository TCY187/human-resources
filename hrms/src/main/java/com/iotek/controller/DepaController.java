package com.iotek.controller;

import com.alibaba.fastjson.JSONArray;
import com.iotek.model.Depa;
import com.iotek.model.Emp;
import com.iotek.service.DepaService;
import com.iotek.service.EmpService;
import com.iotek.service.PositionService;
import com.iotek.service.RecrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
@Controller
public class DepaController {
    @Resource
    private DepaService depaService;
    @Resource
    private PositionService positionService;
    @Resource
    private EmpService empService;
    @Resource
    private RecrService recrService;
    @RequestMapping("/operateDepa")
    public String operateDepa(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session){
        List<Depa> depaList = depaService.getAllDepa();
        int totalNum=depaList.size();
        System.out.println(totalNum);
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Depa> depaList1 = depaService.getAllDepaByPage(begin,end);
        System.out.println(depaList1);
        session.setAttribute("depaList1",depaList1);
        session.setAttribute("depatotalPages",totalPages);
        System.out.println(totalPages);
        return "operateD";
    }
    @RequestMapping("/empgetDepa")
    public String empgetDepa(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session){
        List<Depa> depaList = depaService.getAllDepa();
        int totalNum=depaList.size();
        System.out.println(totalNum);
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Depa> depaList1 = depaService.getAllDepaByPage(begin,end);
        session.setAttribute("empdepaList1",depaList1);
        session.setAttribute("empdepatotalPages",totalPages);
        System.out.println(totalPages);
        return "empListDepa";
    }
    @RequestMapping("/getDepa1")
    public void getDepaAndP(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String p=request.getParameter("key");
        int id = Integer.parseInt(request.getParameter("key"));
        Depa depa = depaService.getDepaByDid(id);
        String positionJson = JSONArray.toJSONString(depa.getPositionList());
        System.out.println(positionJson);
        try {
            response.getWriter().println(positionJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/getDepa")
    public String getDepa(HttpSession session){
        List<Depa> depaList = depaService.getAllDepa();
        session.setAttribute("depaList",depaList);
        return "listDepa";
    }
    @RequestMapping("/deleteDepa")
    public String deleteDepa(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, int did2, HttpSession session, Model model){
        List<Emp> empList = empService.getEmpByDepa(did2);
        if(empList.size()==0){
            boolean flag = depaService.deleteDepa(did2);
//            List<Integer> ridList = recrService.getRidByDid(did2);
            boolean flag1 = recrService.deleteRecrByDid(did2);
            boolean flag2 = positionService.deletePositionByDid(did2);
            List<Depa> depaList = depaService.getAllDepa();
            int totalNum=depaList.size();
            int pageSize=5;
            int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
            int begin = (currentPage-1)*pageSize+1;
            int end = (currentPage-1)*pageSize+pageSize;
            List<Depa> depaList1 = depaService.getAllDepaByPage(begin,end);
            session.setAttribute("depatotalPages",totalPages);
            session.setAttribute("depaList1",depaList1);
            return "operateD";
        }
        model.addAttribute("operateDepaerror","不可删除");
        return "operateD";
    }
    @RequestMapping("/addDepa")
    public String addDepa(){
        return "addDepa";
    }
    @RequestMapping("/addDepa1")
    public String addDepa1(Model model,Depa depa){
        List<Depa> depaList = depaService.getAllDepa();
        for(int i=0;i<depaList.size();i++){
            if(depaList.get(i).getDname().equals(depa.getDname())){
                model.addAttribute("depaerror","已有该部门名");
                return "addDepa";
            }
        }
        depaService.saveDepa(depa);
        return "managerSuccess";
    }
}
