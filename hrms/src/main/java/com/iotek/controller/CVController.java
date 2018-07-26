package com.iotek.controller;

import com.iotek.model.CV;
import com.iotek.model.User;
import com.iotek.service.CVService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by TCY on 2018/7/26.
 */
@Controller
public class CVController {
    @Resource
    private CVService cvService;
    @RequestMapping("/getCV")
    public String getCV(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            List<CV> cvList = cvService.getCVByUid(user);
            session.setAttribute("cvList",cvList);
            return "listCV";
        }
        model.addAttribute("clogerror","ÇëÏÈµÇÂ¼");
        return "../../login";
    }
}
