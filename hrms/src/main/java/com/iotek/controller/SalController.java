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
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        if(day<10){
            model.addAttribute("payMoneyerror","��δ�����ʽ�����");
            return "managerSuccess";
        }
        List<Sal> salList1 = salService.getSalByMonth();
        if(salList1.size()==0){
            List<Emp> empList = empService.getAllEmp();
            System.out.println(empList);
            if(empList.size()==0){
                model.addAttribute("payMoneyerror","û�˷�ʲô����");
                return "managerSuccess";
            }
            for (int i=0;i<empList.size();i++){
                int eid = empList.get(i).getId();
                List<Attendance> attendanceList = attendanceService.getAttendanceByEidLastMonth(eid,1);//�ҳ��ϸ�������������
                Double jsal = empList.get(i).getPosition().getJsal()+((attendanceList.size()-22)*300);//����н��
                if(jsal<0){
                    jsal = 0.0;
                }
                Double pfsal = jsal*empList.get(i).getPosition().getPf();//��Чн��
                Double sssal = jsal*0.15;//�籣
                List<RAP> overrapList = rapService.getRAPByEidAndStateLastMonth(eid,2);//�ҳ����еļӰ��¼
                Double oversal = 0.0;
                if(overrapList.size()!=0){
                    for(int j=0;j<overrapList.size();j++){
                        oversal = oversal+overrapList.get(j).getMoney();
                    }
                }
                List<RAP> raprapList = rapService.getRAPByEidLastMonth(eid,2);//�ҳ����зǼӰ��¼
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
                sal.setIntro(year+"��"+(month-1)+"�¹���");
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
        Sal sal = salService.getSalByEidAndMonth(emp.getId());//��ѯ�ϸ��¹���
        if(sal==null){
            model.addAttribute("salerror","���¹��ʻ�δ����");
            return "empSuccess";
        }
        session.setAttribute("esal",sal);
        return "listSal";
    }
    @RequestMapping("/fuyi")
    public String fuyi(int sid){
        Sal sal = salService.getSalBySid(sid);
        sal.setState(1);
        sal.setIntro(sal.getIntro()+",���븴��");
        salService.updateSal(sal);
        return "empSuccess";
    }
    @RequestMapping("/gzfy")//���ʸ������
    public String gzfy(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,Model model){
        int state = 1;
        List<Sal> salList = salService.getSalByState(1);
        if(salList.size()==0){
            model.addAttribute("gzfyerror","��ǰû�й��ʸ���");
            return "managerSuccess";
        }
        int totalNum=salList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Sal> salList1 = salService.getSalByStateAndPage(state,begin,end);
        session.setAttribute("gzfysalList",salList1);
        session.setAttribute("gzfysaltotalPages",totalPages);
        return "gzfy";
    }
    @RequestMapping("/gzfy1")//���ʸ������
    public String gzfy1(int sid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session,Model model){
        Sal sal = salService.getSalBySid(sid);
        sal.setState(2);
        sal.setIntro(sal.getIntro()+",�Ѵ���");
        salService.updateSal(sal);
        int state = 1;
        List<Sal> salList = salService.getSalByState(1);
        if(salList.size()==0){
            model.addAttribute("gzfyerror","��ǰû�й��ʸ���");
            return "managerSuccess";
        }
        int totalNum=salList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Sal> salList1 = salService.getSalByStateAndPage(state,begin,end);
        session.setAttribute("gzfysalList",salList1);
        session.setAttribute("gzfysaltotalPages",totalPages);
        return "gzfy";
    }
}
