package com.iotek.controller;

import com.iotek.model.CV;
import com.iotek.model.Recr;
import com.iotek.model.User;
import com.iotek.service.CVService;
import com.iotek.service.RecrService;
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
 * Created by TCY on 2018/7/26.
 */
@Controller
public class CVController {
    @Resource
    private RecrService recrService;
    @Resource
    private CVService cvService;
    @RequestMapping("/getCV")
    public String getCV(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session, Model model,int rid){
        User user = (User) session.getAttribute("user");
        Recr recr = recrService.getRecrByRid(rid);
        if(user!=null){
            System.out.println(1);
            List<CV> cvList = cvService.getCVByUid(user.getId());
            System.out.println(cvList);
            int totalNum=cvList.size();
            int pageSize=5;
            int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
            int begin = (currentPage-1)*pageSize+1;
            int end = (currentPage-1)*pageSize+pageSize;
            List<CV> cvList1 = cvService.getCVByUidAndPage(user.getId(),begin,end);
            session.setAttribute("cvList",cvList1);
            session.setAttribute("cvtotalPages",totalPages);
            session.setAttribute("recr",recr);
            return "listCV";
        }
        model.addAttribute("clogerror","ÇëÏÈµÇÂ¼");
        return "../../login";
    }
    @RequestMapping("/getCVDetail")
    public String getCVDetail(int CVDId,HttpSession session){
        CV cv = cvService.getCVByCVid(CVDId);
        session.setAttribute("cvDetail",cv);
        return "listCVDetail";
    }
    @RequestMapping("/deleteCV")
    public String deleteCV(int CVDId2,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session){
        boolean flag = cvService.deleteCVByCVid(CVDId2);
        User user = (User) session.getAttribute("user");
        List<CV> cvList = cvService.getCVByUid(user.getId());
        int totalNum=cvList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<CV> cvList1 = cvService.getCVByUidAndPage(user.getId(),begin,end);
        session.setAttribute("cvList",cvList1);
        session.setAttribute("cvtotalPages",totalPages);
        return "listCV";
    }
    @RequestMapping("/saveCV")
    public String saveCV(){
        return "saveCV";
    }
    @RequestMapping("/saveCV1")
    public String saveCV1(String birth1,CV cv,HttpSession session,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage) throws ParseException{
        User user = (User) session.getAttribute("user");
        System.out.println(birth1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse(birth1);
        cv.setBirth(birth);
        cv.setUser(user);
        System.out.println(cv);
        boolean flag = cvService.saveCV(cv);
        List<CV> cvList = cvService.getCVByUid(user.getId());
        int totalNum=cvList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<CV> cvList1 = cvService.getCVByUidAndPage(user.getId(),begin,end);
        session.setAttribute("cvList",cvList1);
        session.setAttribute("cvtotalPages",totalPages);
        return "listCV";
    }
    @RequestMapping("/updateCV")
    public String updateCV(int CVId,String birth1,CV cv,HttpSession session,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage) throws ParseException{
        User user = (User) session.getAttribute("user");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse(birth1);
        cv.setId(CVId);
        cv.setBirth(birth);
        cv.setUser(user);
        boolean flag = cvService.updateCV(cv);
        List<CV> cvList = cvService.getCVByUid(user.getId());
        int totalNum=cvList.size();
        int pageSize=5;
        int totalPages=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<CV> cvList1 = cvService.getCVByUidAndPage(user.getId(),begin,end);
        session.setAttribute("cvList",cvList1);
        session.setAttribute("cvtotalPages",totalPages);
        return "listCV";
    }
}
