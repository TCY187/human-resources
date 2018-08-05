package com.iotek.controller;

import com.iotek.model.Cul;
import com.iotek.model.Depa;
import com.iotek.model.Emp;
import com.iotek.service.CulService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TCY on 2018/8/2.
 */
@Controller
public class CulController {
    @Resource
    private EmpService empService;
    @Resource
    private DepaService depaService;
    @Resource
    private CulService culService;
    @RequestMapping("/aboutCul")
    public String aboutCul(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        int state = 1;
        List<Cul> culList = culService.getCulByState(state);
        int totalNum=culList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cul> culList1 = culService.getCulByStateAndPage(state,begin,end);
        session.setAttribute("culList",culList1);
        session.setAttribute("cultotalPages",totalPages);
        return "aboutCul";
    }
    @RequestMapping("/addDCul")
    public String addDCul(){
        return "addDCul";
    }
    @RequestMapping("/addDCul1")
    public String addDCul1(Cul cul,String betime,String entime,HttpSession session)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begintime = sdf.parse(betime);
        Date endtime = sdf.parse(entime);
        cul.setBegintime(begintime);
        cul.setEndtime(endtime);
        cul.setState(0);//未发布
        culService.saveCul(cul);
//        int cid = cul.getId();
//        System.out.println(cid);
//        Cul cul1 = culService.getCulByCid(cid);
        List<Depa> depaList = depaService.getAllDepa();
        session.setAttribute("cul",cul);
        session.setAttribute("culdepaList",depaList);
        return "addDCul1";
    }
    @RequestMapping("/addDCul2")
    public String addDCul2(int did,HttpSession session){
        Depa depa = depaService.getDepaByDid(did);
        Cul cul = (Cul) session.getAttribute("cul");
        int cid = cul.getId();
        List<Emp> empList = empService.getEmpByDepa(did);
        for(int i=0;i<empList.size();i++){
            int eid = empList.get(i).getId();
            culService.saveEC(eid,cid);
        }
        session.setAttribute("culdepa",depa);
        return "addDCul2";
    }
    @RequestMapping("/issueCul")
    public String issueCul(int cid){
        int state = 1;
        Date issuetime = new Date();
        culService.updateCulStateByCid(state,issuetime,cid);
        return "managerSuccess";
    }
    @RequestMapping("/addECul")
    public String addECul(){
        return "addECul";
    }
    @RequestMapping("/addECul1")
    public String addECul1(Cul cul,String betime,String entime,HttpSession session)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begintime = sdf.parse(betime);
        Date endtime = sdf.parse(entime);
        cul.setBegintime(begintime);
        cul.setEndtime(endtime);
        cul.setState(0);//未发布
        culService.saveCul(cul);
        int cid = cul.getId();
        Date date = new Date();
        List<Emp> empList = empService.getAllEmp();
        List<Integer> eids = new ArrayList<Integer>();
        for(int i=0;i<empList.size();i++){
            Date entrytime = empList.get(i).getEntrytime();
            Long time = (date.getTime()-entrytime.getTime())/(60*1000*60*24*30);
            if(time<1){
                eids.add(empList.get(i).getId());
            }
        }
        for(int j=0;j<eids.size();j++){
            culService.saveEC(eids.get(j),cid);
        }
        session.setAttribute("cul",cul);
        session.setAttribute("culempList",empList);
        return "addECul1";
    }
    @RequestMapping("/recall")
    public String recall(Model model, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session, int cid){
        Cul cul = culService.getCulByCid(cid);
        Date date = new Date();
        long time = (date.getTime()-cul.getIssuetime().getTime())/(1000*60);
        if(time<10){
            Date date1 = null;
            int state1 = 0;
            culService.updateCulStateByCid(state1,date1,cid);
            int state = 1;
            List<Cul> culList = culService.getCulByState(state);
            int totalNum=culList.size();
            int pageSize=5;
            int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
            int begin = (currentPage-1)*pageSize+1;
            int end = (currentPage-1)*pageSize+pageSize;
            List<Cul> culList1 = culService.getCulByStateAndPage(state,begin,end);
            session.setAttribute("culList",culList1);
            session.setAttribute("cultotalPages",totalPages);
            return "aboutCul";
        }
        model.addAttribute("recallerror","不可撤回");
        return "aboutCul";
    }

    @RequestMapping("/noIssueCul")
    public String noIssueCul(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        int state = 0;
        List<Cul> culList = culService.getCulByState(state);
        int totalNum=culList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cul> culList1 = culService.getCulByStateAndPage(state,begin,end);
        session.setAttribute("noIssueCulList",culList1);
        session.setAttribute("noIssueCultotalPages",totalPages);
        return "listnoIssueCul";
    }
    @RequestMapping("/deleteCul")
    public String deleteCul(int cid1,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        culService.deleteCulByCid(cid1);
        culService.deleteECByCid(cid1);
        int state = 0;
        List<Cul> culList = culService.getCulByState(state);
        int totalNum=culList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cul> culList1 = culService.getCulByStateAndPage(state,begin,end);
        session.setAttribute("noIssueCulList",culList1);
        session.setAttribute("noIssueCultotalPages",totalPages);
        return "listnoIssueCul";
    }
    @RequestMapping("/updateCul")
    public String updateCul(int cid2, HttpSession session){
        Cul cul = culService.getCulByCid(cid2);
        session.setAttribute("updateCul",cul);
        return "updateCul";
    }
    @RequestMapping("/updateCul1")
    public String updateCul1(String theme1,String address1,String content1,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        Cul cul = (Cul)session.getAttribute("updateCul");
        cul.setAddress(address1);
        cul.setContent(content1);
        cul.setTheme(theme1);
        culService.updateCulByCid(cul);
        int state = 0;
        List<Cul> culList = culService.getCulByState(state);
        int totalNum=culList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cul> culList1 = culService.getCulByStateAndPage(state,begin,end);
        session.setAttribute("noIssueCulList",culList1);
        session.setAttribute("noIssueCultotalPages",totalPages);
        return "listnoIssueCul";
    }
    @RequestMapping("/getCulByEid")
    public String getCulByEid(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session){
        Emp emp  = (Emp) session.getAttribute("emp");
        int state=1;
        List<Cul> culList = culService.getCulByEidAndState(emp.getId(),state);
        session.setAttribute("empCulList",culList);
//        session.setAttribute("empCultotalPages",totalPages);
        return "listEmpCul";
    }
}
