/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.DAO.BookDAO;
import com.me.bean.Book;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.filters.CrossScriptingFilter;
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
public class BrowseBookController extends AbstractController {

    private static Logger logger = Logger.getLogger(BrowseBookController.class);
    @Autowired
    private StatsDClient statsDclient;



    
    public BrowseBookController() {
    }
    
   
    public ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StopWatch stopwatch = StopWatch.createStarted();


        logger.info("Browsing uploads or Browsing Cart");


        ModelAndView mv = null;
        String searchKey =req.getParameter("by");
        String searchValue=req.getParameter("key");
        String uname = req.getParameter("uname");
        List<Book> results = null;
         BookDAO bookdao =new BookDAO();
        if(searchKey.equals("seller")){
                
                results = bookdao.searchBookbySeller(searchValue);

            statsDclient.incrementCounter("viewUploads");
            logger.info("viewing uploads");

                 mv = new ModelAndView("Result","book",results);
                 
                 mv.addObject("key", searchValue);

            stopwatch.stop();
            statsDclient.recordExecutionTime("viewUploads", stopwatch.getTime());
            statsDclient.recordExecutionTime("getImageFromS3", stopwatch.getTime());

        } else if(searchKey.equals("all")){
                
                results = bookdao.searchBookbyAll(searchValue);

            statsDclient.incrementCounter("viewListing");
            logger.info("viewing listing");

                 mv = new ModelAndView("Result2","book",results);
            mv.addObject("key", searchValue);
            mv.addObject("uname", uname);

            stopwatch.stop();
            statsDclient.recordExecutionTime("viewListing", stopwatch.getTime());
            statsDclient.recordExecutionTime("getImageFromS3", stopwatch.getTime());
                
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