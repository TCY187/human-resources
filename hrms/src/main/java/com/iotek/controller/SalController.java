package com.iotek.controller;

import com.iotek.model.Attendance;
import com.iotek.model.Emp;
import com.iotek.model.RAP;
import com.iotek.model.Sal;
import com.iotek.service.AttendanceService;
import com.iotek.service.EmpService;
import com.iotek.service.RAPService;
import com.iotek.service.SalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/8/3.
 */
@Controller
public class SalController {
    @Resource
    private EmpService empService;
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private RAPService rapService;
    @Resource
    private SalService salService;
    @RequestMapping("/payMoney")
    public String payMoney(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model, HttpSession session){
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DATE);
        if(day==10){
            model.addAttribute("payMoneyerror","还未到工资结算日");
            return "managerSuccess";
        }
        List<Sal> salList1 = salService.getSalByMonth();
        if(salList1.size()==0){
            List<Emp> empList = empService.getAllEmp();
            System.out.println(empList);
            if(empList.size()==0){
                model.addAttribute("payMoneyerror","没人发什么工资");
                return "managerSuccess";
            }
            for (int i=0;i<empList.size();i++){
                int eid = empList.get(i).getId();
                List<Attendance> attendanceList = attendanceService.getAttendanceByEidLastMonth(eid,1);//找出上个月正常打卡天数
                Double jsal = empList.get(i).getPosition().getJsal()+((attendanceList.size()-22)*300);//基本薪资
                if(jsal<0){
                    jsal = 0.0;
                }
                Double pfsal = jsal*empList.get(i).getPosition().getPf();//绩效薪资
                Double sssal = jsal*0.15;//社保
                List<RAP> overrapList = rapService.getRAPByEidAndStateLastMonth(eid,2);//找出所有的加班记录
                Double oversal = 0.0;
                if(overrapList.size()!=0){
                    for(int j=0;j<overrapList.size();j++){
                        oversal = oversal+overrapList.get(j).getMoney();
                    }
                }
                List<RAP> raprapList = rapService.getRAPByEidLastMonth(eid,2);//找出所有非加班记录
                Double rapsal = 0.0;
                if(raprapList.size()!=0){
                    for(int k=0;k<raprapList.size();k++){
                        rapsal = rapsal+raprapList.get(k).getMoney();
                    }
                }
                Double allsal = jsal+pfsal+oversal+rapsal-sssal;
                Sal sal = new Sal();
                sal.setEmp(empList.get(i));
                sal.setJsal(jsal);
                sal.setPfsal(pfsal);
                sal.setOversal(oversal);
                sal.setSssal(sssal);
                sal.setRapsal(rapsal);
                sal.setSal(allsal);
                sal.setState(0);
                sal.setIntro("上月工资");
                System.out.println(sal);
                salService.saveSal(sal);
            }
        }
        List<Sal> salList = salService.getSalByMonth();
        int totalNum=salList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Sal> salList2 = salService.getSalByMonthAndPage(begin,end);
        session.setAttribute("salList",salList2);
        session.setAttribute("saltotalPages",totalPages);
        return "listPayMoney";
    }
    @RequestMapping("/getSalByEid")
    public String getSalByEid(HttpSession session,Model model){
        Emp emp  = (Emp) session.getAttribute("emp");
        Sal sal = salService.getSalByEidAndMonth(emp.getId());
        if(sal==null){
            model.addAttribute("salerror","上月工资还未发放");
            return "empSuccess";
        }
        session.setAttribute("esal",sal);
        return "listSal";
    }
}
