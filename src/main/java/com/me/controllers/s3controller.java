package com.me.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import org.apache.log4j.Logger;
/**
 *
 * @author anish
 */
public class s3controller extends AbstractController {

    public s3controller() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String option = request.getParameter("option");

        if(option !=null && option.equalsIgnoreCase("Add image"))
        {
            mv= new ModelAndView("addimage");

        }
        else
        {

            mv = new ModelAndView("SellBooks");
        }


        return mv;
    }

}