/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class BookController extends AbstractController {
    
    public BookController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            ModelAndView mv = null;
        String option = request.getParameter("option");
        String uname = request.getParameter("uname");
        String uname2 = request.getParameter("uname2");
        if(option !=null && option.equalsIgnoreCase("Edit Books"))
        {
            mv= new ModelAndView("BuyBooks");
            mv.addObject("uname2", uname2);
        }
        else if(option !=null && option.equalsIgnoreCase("Sell Books"))
        {
            mv= new ModelAndView("SellBooks");
            mv.addObject("uname", uname);
        }
        else
        {
       
            mv = new ModelAndView("Welcome");
        }
        
     
        return mv;
    }
    
}
