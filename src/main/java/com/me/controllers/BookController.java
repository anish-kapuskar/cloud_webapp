/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.timgroup.statsd.StatsDClient;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
/**
 *
 * @author anish
 */
public class BookController extends AbstractController {

    @Autowired
    private StatsDClient statsDclient;
    
    public BookController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        StopWatch stopwatch = StopWatch.createStarted();
            ModelAndView mv = null;
        String option = request.getParameter("option");
        String uname = request.getParameter("uname");
        String uname2 = request.getParameter("uname2");
        if(option !=null && option.equalsIgnoreCase("Edit Books"))
        {
            mv= new ModelAndView("BuyBooks");
            mv.addObject("uname2", uname2);
            stopwatch.stop();
            statsDclient.recordExecutionTime("goToBuyBooks", stopwatch.getTime());
        }
        else if(option !=null && option.equalsIgnoreCase("Sell Books"))
        {
            mv= new ModelAndView("SellBooks");
            mv.addObject("uname", uname);
            stopwatch.stop();
            statsDclient.recordExecutionTime("goToSellBooks", stopwatch.getTime());
        }
        else
        {
       
            mv = new ModelAndView("Welcome");
            stopwatch.stop();
            statsDclient.recordExecutionTime("goToWelcome", stopwatch.getTime());
        }
        
     
        return mv;
    }
    
}
