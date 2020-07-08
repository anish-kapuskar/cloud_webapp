/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.me.DAO.BookDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class DeleteBookController extends AbstractController {

    private static final Logger logger=Logger.getLogger(DeleteBookController.class);
    @Autowired
    private StatsDClient statsDclient;

    @Autowired
    private AmazonS3 s3client;

    @Value("http://webapp.anish.kapuskar.s3-website-us-east-1.amazonaws.com")
    private String endpointUrl;

    @Value("webapp.anish.kapuskar")
    private String bucketName;

    public DeleteBookController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        StopWatch stopwatch = StopWatch.createStarted();

            ModelAndView mv = null;
                    BookDAO bookdao = new BookDAO();
        String option = request.getParameter("option");
        if(option ==null || option.isEmpty()) 
        {
            statsDclient.incrementCounter("viewUploads");
            logger.info("viewing uploads");
            mv= new ModelAndView("Result");
            stopwatch.stop();
            statsDclient.recordExecutionTime("viewUploads", stopwatch.getTime());
        }
        else
        {
           int id = Integer.parseInt(request.getParameter("id"));
           String image = request.getParameter("image");
            deleteFile(image);
           int result=bookdao.deleteBookById(id);
           if (result==1){
           mv= new ModelAndView("deleteSuccess","message","Book Deleted!");
           mv.addObject(image);
            logger.info("Delete successful");
               stopwatch.stop();
               statsDclient.recordExecutionTime("deleteSuccess", stopwatch.getTime());
           }
           else{
               mv= new ModelAndView("deleteError","message","Could not Delete!");
                logger.info("Delete not successful");
               stopwatch.stop();
               statsDclient.recordExecutionTime("deleteNotSuccess", stopwatch.getTime());
           }
        }
       
        
     
        return mv;
    }

    public void deleteFile(final String fileName) {

        final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, fileName);
        s3client.deleteObject(deleteObjectRequest);

    }
    
}

