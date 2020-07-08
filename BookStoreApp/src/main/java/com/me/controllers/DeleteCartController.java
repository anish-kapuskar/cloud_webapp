/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.DAO.CartDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.timgroup.statsd.StatsDClient;
import org.apache.log4j.Logger;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author Lord Aegon
 */
public class DeleteCartController extends AbstractController {

    private static final Logger logger=Logger.getLogger(BrowseBookController.class);
    @Autowired
    private StatsDClient statsDclient;

    public DeleteCartController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        StopWatch stopwatch = StopWatch.createStarted();

        ModelAndView mv = null;
        CartDAO cartdao = new CartDAO();
        String option = request.getParameter("option");
        if(option ==null || option.isEmpty())
        {
            statsDclient.incrementCounter("viewCart");
            logger.info("viewing cart");
            mv= new ModelAndView("ResultCart");

            stopwatch.stop();
            statsDclient.recordExecutionTime("goToResultCart", stopwatch.getTime());
        }
        else
        {
            int id = Integer.parseInt(request.getParameter("id"));
            int result=cartdao.deleteCartById(id);
            if (result==1){
                mv= new ModelAndView("deleteSuccess","message","Book Removed from Cart!");
                logger.info("Delete successful");
                stopwatch.stop();
                statsDclient.recordExecutionTime("deleteSuccess", stopwatch.getTime());
            }
            else{
                mv= new ModelAndView("deleteError","message","Could not remove!");
                logger.info("Delete not successful");
                stopwatch.stop();
                statsDclient.recordExecutionTime("deleteError", stopwatch.getTime());
            }
        }



        return mv;
    }

}

