package com.iotek.controller;

import com.iotek.model.Attendance;
import com.iotek.model.Emp;
import com.iotek.model.RAP;
import com.iotek.service.AttendanceService;
import com.iotek.service.RAPService;
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
public class AttendanceController {
    @Resource
    private RAPService rapService;
    @Resource
    private AttendanceService attendanceService;
    @RequestMapping("/clockon")
    public String clockon(HttpSession session, Model model){
        Emp emp  = (Emp) session.getAttribute("emp");
        Attendance attendance1 = attendanceService.getAttendanceByEid(emp.getId());
        System.out.println(attendance1);
        if(attendance1!=null){
            model.addAttribute("clockerror","�����ظ��ϰ��");
            return "empSuccess";
        }else {
            Attendance attendance = new Attendance();
            attendance.setEmp(emp);
            attendance.setState(0);
            boolean flag = attendanceService.saveAttendance(attendance);
            if(flag){
                model.addAttribute("clockerror","��ʼ���ֹ���");
                return "empSuccess";
            }
            model.addAttribute("clockerror","�ϰ��ʧ��");
            return "empSuccess";
        }
    }
    @RequestMapping("/clockoff")
    public String clockoff(HttpSession session, Model model){
        Emp emp  = (Emp) session.getAttribute("emp");
        Attendance attendance1 = attendanceService.getAttendanceByEid(emp.getId());
        //����9��
        Calendar a = Calendar.getInstance();
        a.set(Calendar.HOUR_OF_DAY, 9);
        a.set(Calendar.MINUTE, 0);
        a.set(Calendar.SECOND, 0);
        Date atime = a.getTime();
        //����18��
        Calendar b = Calendar.getInstance();
        b.set(Calendar.HOUR_OF_DAY, 18);
        b.set(Calendar.MINUTE, 0);
        b.set(Calendar.SECOND, 0);
        Date btime = b.getTime();
        if(attendance1!=null){
            if(attendance1.getOfftime()==null){//��һ���ϰ��
                attendanceService.updateAttendance(attendance1.getId());
                Attendance attendance = attendanceService.getAttendanceByEid(emp.getId());
                long clockontime = (atime.getTime()-attendance.getOntime().getTime());
                long clockofftime = (attendance.getOfftime().getTime()-btime.getTime());
                long totaltime = 0;
                int overtime = (int) (clockofftime/(1000*60*60));//�Ӱ�Сʱ��
                //���ɼӰཱ�ͽ���Ӱཱ��
                if(overtime>0){
                    Double money = overtime*100.0;
                    RAP rap = new RAP();
                    rap.setMoney(money);
                    rap.setEmp(emp);
                    rap.setIntro("�Ӱ�");
                    rap.setState(2);
                    rapService.saveRAP(rap);
                }
                //�����Ƿ�ٵ����˻����
                if(clockontime<0){
                    totaltime = totaltime+clockontime;
                }
                if(clockofftime<0){
                    totaltime = totaltime+clockofftime;
                }
                if(totaltime==0){
                    model.addAttribute("clockerror","�����ˣ�һ������");
                    return "empSuccess";
                }else if(( (0-totaltime) / (1000*60*60) )>2){//�ٵ������ܼƳ�����Сʱ�������
                    attendanceService.updateAttendanceNull(attendance.getId());
                    model.addAttribute("clockerror","�����ˣ��������һ��ǮҲ�ò���");
                    return "empSuccess";
                }else{
                    if(clockontime<0){//��ӳٵ���¼
                        Double money1 = (( (0-clockontime) / (1000*60*60) )+1)*50.0;
                        RAP rap1 = new RAP();
                        rap1.setMoney(0-money1);
                        rap1.setEmp(emp);
                        rap1.setIntro("�ٵ�");
                        rap1.setState(0);
                        rapService.saveRAP(rap1);
                    }
                    if(clockofftime<0){//������˼�¼
                        Double money1 = (( (0-clockofftime) / (1000*60*60) )+1)*50.0;
                        RAP rap1 = new RAP();
                        rap1.setMoney(0-money1);
                        rap1.setEmp(emp);
                        rap1.setIntro("����");
                        rap1.setState(1);
                        rapService.saveRAP(rap1);
                    }
                    model.addAttribute("clockerror","�����ˣ�����Ǯ");
                    return "empSuccess";
                }
            }
            //�ǵ�һ�δ�
            else{
                RAP rap1 = rapService.getRAPByEidAndSateAndSysdate(emp.getId(),1);//�ҵ���������˼�¼
                RAP rap2 = rapService.getRAPByEidAndSateAndSysdate(emp.getId(),2);//�ҵ�����ļӰ��¼
                if(attendance1.getState()==2){//���������Դ�ڶ���
                    model.addAttribute("clockerror","���������ڶ��Σ�");
                    return "empSuccess";
                }
                if(rap1!=null){//���˲����Դ�ڶ���
                    model.addAttribute("clockerror","���˻����ڶ��Σ�");
                    return "empSuccess";
                }
                if(rap2!=null){//���ʹ��ڼӰ࣬��ɾ�������
                    rapService.deleteRAPByRAid(rap2.getId());
                }
                attendanceService.updateAttendance(attendance1.getId());//ˢ���°�ʱ��
                Attendance attendance = attendanceService.getAttendanceByEid(emp.getId());
                long clockofftime = (attendance.getOfftime().getTime()-btime.getTime());
                int overtime = (int) (clockofftime/(1000*60*60));//�Ӱ�Сʱ��
                //���ɼӰཱ�ͽ���Ӱཱ��
                if(overtime>0){
                    Double money = overtime*100.0;
                    RAP rap = new RAP();
                    rap.setMoney(money);
                    rap.setEmp(emp);
                    rap.setIntro("�Ӱ�");
                    rap.setState(2);
                    rapService.saveRAP(rap);
                    model.addAttribute("clockerror","�����ˣ�����δ��мӰཱ��Ӵ");
                    return "empSuccess";
                }
                model.addAttribute("clockerror","�����ˣ����ǣ����꣬û�仯������");
                return "empSuccess";
            }
        }
        model.addAttribute("clockerror","�ϰ�δ�򿨣��°಻�ɴ�");
        return "empSuccess";
    }
    @RequestMapping("/getAttendanceByEid")
    public String getAttendanceByEid(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        Emp emp  = (Emp) session.getAttribute("emp");
        List<Attendance> attendanceList = attendanceService.getAttendanceByEid1(emp.getId());
        int totalNum=attendanceList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendanceList1 = attendanceService.getAttendanceByEid1AndPage(emp.getId(),begin,end);
        session.setAttribute("attendanceList",attendanceList1);
        session.setAttribute("attendancetotalPages",totalPages);
        return "listAttendance";
    }
    @RequestMapping("/mgetAttenByEmp")
    public String mgetAttenByEmp(int eid4,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        List<Attendance> attendanceList = attendanceService.getAttenByEid(eid4);
        int totalNum=attendanceList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendanceList1 = attendanceService.getAttenByEidAndPage(eid4,begin,end);
        session.setAttribute("attenList",attendanceList1);
        session.setAttribute("attentotalPages",totalPages);
        return "listAtten";
    }
}
