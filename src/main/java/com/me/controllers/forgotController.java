package com.me.controllers;



import com.me.controllers.SNSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class forgotController extends AbstractController {

    @Autowired
    private SNSUtil snsUtil;

    public forgotController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = null;

        String email =request.getParameter("email");

        this.snsUtil.publishSNSMessage(email);

             mv= new ModelAndView("Welcome");

        return mv;
    }

}
