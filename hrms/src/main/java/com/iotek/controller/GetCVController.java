package com.iotek.controller;

import com.iotek.model.CV;
import com.iotek.model.Recr;
import com.iotek.service.CVService;
import com.iotek.service.GetCVService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by TCY on 2018/7/26.
 */
@Controller
public class GetCVController {
    @Resource
    private CVService cvService;
    @Resource
    private GetCVService getCVService;
    @RequestMapping("/sendCV")
    public String sendCV(int CVDId1, HttpSession session){
        Recr recr = (Recr) session.getAttribute("recr");
        CV cv = cvService.getCVByCVid(CVDId1);
        boolean flag = getCVService.saveGetCV(cv.getId(),recr.getId());
        return "../../login";
    }
}
