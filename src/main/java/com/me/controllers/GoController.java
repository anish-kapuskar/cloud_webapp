/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author anish
 */

public class GoController extends AbstractController {

    public GoController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;



        String option = request.getParameter("option");
        if(option !=null && option.equalsIgnoreCase("Go"))
        {
            mv= new ModelAndView("User");
        }

        else
        {
            mv = new ModelAndView("Welcome");
        }
        return mv;
    }

}