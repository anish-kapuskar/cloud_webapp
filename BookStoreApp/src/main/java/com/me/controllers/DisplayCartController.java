/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.DAO.CartDAO;
import com.me.bean.Cart;

import java.io.IOException;
import java.util.List;
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
 * @author anish
 */
public class DisplayCartController extends AbstractController {

    private static final Logger logger=Logger.getLogger(BrowseBookController.class);
    @Autowired
    private StatsDClient statsDclient;

    public DisplayCartController() {
    }


    public ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StopWatch stopwatch = StopWatch.createStarted();


        ModelAndView mv = null;
        String searchKey =req.getParameter("by");
        String searchValue=req.getParameter("key");
        String uname = req.getParameter("uname");
        List<Cart> results = null;
        CartDAO cartdao =new CartDAO();
        if(searchKey.equals("buyer")){

            results = cartdao.searchCartbyBuyer(searchValue);

            statsDclient.incrementCounter("viewCart");
            logger.info("viewing cart");

            mv = new ModelAndView("ResultCart","cart",results);

            mv.addObject("key", searchValue);
            mv.addObject("uname",uname);

            stopwatch.stop();
            statsDclient.recordExecutionTime("viewCart", stopwatch.getTime());

        }
        /**
         if(searchKey!=null && searchValue!=null  && (!searchKey.equals("")))
         {
         req.setAttribute("searchKey", searchValue);
         BookDAO bookdao =new BookDAO();
         //            BookDAO mdao = (BookDAO) this.getApplicationContext().getBean("moviedao");
         Book mf = bookdao.browseBook(searchKey, searchValue);
         mv = new ModelAndView("Result", "book",mf);

         }
         else
         {
         req.setAttribute("searchKey", null);
         mv = new ModelAndView("BrowseBooks");

         }
         */
        return mv;
    }



    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        return doGet(hsr,hsr1);

    }

}