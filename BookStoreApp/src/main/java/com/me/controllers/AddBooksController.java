/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.me.DAO.BookDAO;
import com.me.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.timgroup.statsd.StatsDClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author anish
 */
public class AddBooksController extends AbstractController{

    @Autowired
    private StatsDClient statsDclient;



    @Autowired
    private AmazonS3 s3client;

    @Value("https://s3.amazonaws.com")
    private String endpointUrl;

    @Value("webapp.anish.kapuskar")
    private String bucketName;

 public ModelAndView doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

     StopWatch stopwatch = StopWatch.createStarted();
       
       Book book =new Book();
      
     
      String isbn=req.getParameter("isbn");
      String title=req.getParameter("title");
      String authors=req.getParameter("authors");
      String date=req.getParameter("date");
      Integer quantity=Integer.parseInt(req.getParameter("quantity"));
      Double price =Double.parseDouble(req.getParameter("price"));
      String seller = req.getParameter("seller");
      String time = req.getParameter("time");
      String file = req.getParameter("file");

     String fileUrl = endpointUrl + "/" + bucketName + "/" + file;
      
      book.setIsbn(isbn);
      book.setTitle(title);
      book.setAuthors(authors);
      book.setDate(date);
      book.setQuantity(quantity);
      book.setPrice(price);
      book.setSeller(seller);
      book.setTime(time);
      book.setImage(fileUrl);
      book.setImagename(file);

      BookDAO bookDao = new BookDAO();
      bookDao.addBook(book);

      ModelAndView mv=new ModelAndView("AddedBook");

     stopwatch.stop();
     statsDclient.recordExecutionTime("addBookToDb", stopwatch.getTime());

       return mv;
   }

   @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       return doPost(hsr,hsr1);
        
    }
}
