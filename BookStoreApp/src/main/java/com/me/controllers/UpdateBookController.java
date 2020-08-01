/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.me.DAO.BookDAO;
import com.me.bean.Book;

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
public class UpdateBookController extends AbstractController {

    private static final Logger logger=Logger.getLogger(BrowseBookController.class);
    @Autowired
    private StatsDClient statsDclient;

    @Autowired
    private AmazonS3 s3client;

    @Value("http://webapp.anish.kapuskar.s3-website-us-east-1.amazonaws.com")
    private String endpointUrl;

    @Value("webapp.anish.kapuskar")
    private String bucketName;
    
    public UpdateBookController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            ModelAndView mv = null;
                    BookDAO bookdao = new BookDAO();
        String option = request.getParameter("option");
        String imagename = request.getParameter("imagename");
        deleteFile(imagename);
        String imagename2 = request.getParameter("imagename2");
        deleteFile(imagename2);
        String imagename3 = request.getParameter("imagename3");
        deleteFile(imagename3);
        if(option ==null || option.isEmpty()) 
        {
            statsDclient.incrementCounter("viewUploads");
            logger.info("viewing uploads");
            mv= new ModelAndView("Result");
        }
        else if(option.equalsIgnoreCase("update"))
        {
           int id = Integer.parseInt(request.getParameter("id"));
           Book updatedBook = bookdao.getBookById(id);
            mv= new ModelAndView("updateBook","message", updatedBook);
           }
           else{
      int id=Integer.parseInt(request.getParameter("id"));
      String isbn=request.getParameter("isbn");
      String title=request.getParameter("title");
      String authors=request.getParameter("authors");
      String date=request.getParameter("date");
      int quantity=Integer.parseInt(request.getParameter("quantity"));
            double price=Double.parseDouble(request.getParameter("price"));
            String seller=request.getParameter("seller");
            String time =request.getParameter("time");
            String image = request.getParameter("image");
            String image2 = request.getParameter("image2");
            String image3 = request.getParameter("image3");
      
      int result=bookdao.updateBook(id,isbn, title, authors, date, quantity, price, seller,time,image,image2,image3);
      
      if(result==1){
      String msg= "Book with id" + id + "has been updated successfully";
      mv= new ModelAndView("deleteSuccess","message",msg); 
      }
      else{
      mv= new ModelAndView("deleteSuccess","message","Could not update book");
      }
      
           }
         return mv;
        }
    public void deleteFile(final String fileName) {

        final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, fileName);
        s3client.deleteObject(deleteObjectRequest);

    }
} 
        
     
       
    
    

