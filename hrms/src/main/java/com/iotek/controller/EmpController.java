package com.iotek.controller;

import com.iotek.model.Depa;
import com.iotek.model.Emp;
import com.iotek.model.Position;
import com.iotek.model.User;
import com.iotek.service.DepaService;
import com.iotek.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/7/27.
 */
@Controller
public class EmpController {
    @Resource
    private DepaService depaService;
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
    @RequestMapping("/empgetEmpByPosition")
    public String empgetEmpByPosition(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, int pid2, HttpSession session){
        List<Emp> empList = empService.getEmpByPosition(pid2);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1= empService.getEmpByPositionAndPage(pid2,begin,end);
        session.setAttribute("empemppList",empList1);
        session.setAttribute("empempptotalPages",totalPages);
        return "emplistPEmp";
    }
    @RequestMapping("/quit1")
    public String quit1(HttpSession session,int eid){
        Emp emp = empService.getEmpByEid(eid);
        session.setAttribute("quitemp",emp);
        return "quitintro";
    }
    @RequestMapping("/quit")
    public String quit(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,String intro){
        Emp emp = (Emp) session.getAttribute("quitemp");
        boolean flag = empService.updateQuitEmp(emp.getId(),intro);
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
        Emp emp1 = empService.getEmpByPass(emp);
        if(emp1!=null){
            session.setAttribute("emp",emp1);
            return "empSuccess";
        }
        model.addAttribute("emplogerror","登录名或密码错误");
        return "../../login";
    }
    @RequestMapping("/getEmpByEmp")
    public String getEmpByEmp(){
        return "listEmpDetail";
    }
    @RequestMapping("/mgetEmpDetail")
    public String mgetEmpDetail(int eid3,HttpSession session){
        Emp emp = empService.getEmpByEid(eid3);
        session.setAttribute("memp",emp);
        return "mlistEmpDetail";
    }
    @RequestMapping("/updateEmpDetail")
    public String updateEmpDetail(int eid,String birth1,Emp emp,HttpSession session) throws ParseException {
        Emp emp1 = (Emp) session.getAttribute("emp");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse(birth1);
        emp.setId(eid);
        emp.setBirth(birth);
        emp.setState(emp1.getState());
        emp.setEname(emp1.getEname());
        emp.setEntrytime(emp1.getEntrytime());
        emp.setPosition(emp1.getPosition());
        emp.setDepa(emp1.getDepa());
        empService.updateEmp(emp);
        Emp emp2 = empService.getEmpByPass(emp);
        session.setAttribute("emp",emp2);
        return "empSuccess";
    }
    @RequestMapping("/zhuanzheng")
    public String zhuanzheng(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        int state = 0;
        List<Emp> empList = empService.getEmpByState(state);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1= empService.getEmpByStateAndPage(state,begin,end);
        session.setAttribute("stateempList",empList1);
        session.setAttribute("stateemptotalPages",totalPages);
        return "stateListEmp";
    }
    @RequestMapping("/zhuanzheng1")
    public String zhuanzheng1(Model model, int eid1,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        Emp emp = empService.getEmpByEid(eid1);
        Date date = new Date();
        long time = date.getTime()-emp.getEntrytime().getTime();
        int day = (int) (time/(1000*60*60*24));
        System.out.println("+++++++++++++++"+day);
        if(day>30){
            emp.setState(1);
            empService.updateEmpState(emp);
        }else{
            model.addAttribute("stateerror","该员工未满一个月，不可转正");
        }
        int state = 0;
        List<Emp> empList = empService.getEmpByState(state);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1= empService.getEmpByStateAndPage(state,begin,end);
        session.setAttribute("stateempList",empList1);
        session.setAttribute("stateemptotalPages",totalPages);
        return "stateListEmp";
    }
    @RequestMapping("/relieveguard")
    public String relieveguard(int eid2,HttpSession session){
        Emp emp = empService.getEmpByEid(eid2);
        session.setAttribute("RGemp",emp);
        List<Depa> depaList = depaService.getAllDepa();
        session.setAttribute("depaList",depaList);
        return "relieveguard";
    }
    @RequestMapping("/relieveguard1")
    public String relieveguard1(int selectDep,int selectPosition,HttpSession session){
        Emp emp = (Emp) session.getAttribute("RGemp");
        Depa depa = new Depa();
        depa.setId(selectDep);
        Position position  = new Position();
        position.setId(selectPosition);
        emp.setPosition(position);
        emp.setDepa(depa);
        empService.updateEmpDP(emp);
        return "managerSuccess";
    }
    @RequestMapping("/getquitEmp")
    public String getquitEmp(Model model,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session){
        int state = 2;
        List<Emp> empList = empService.getEmpByState(state);
        int totalNum=empList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Emp> empList1= empService.getEmpByStateAndPage(state,begin,end);
        session.setAttribute("quitempList",empList1);
        session.setAttribute("quitemptotalPages",totalPages);
        return "quitListEmp";
    }
}
