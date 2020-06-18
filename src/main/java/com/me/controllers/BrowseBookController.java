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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author anish
 */
public class BrowseBookController extends AbstractController {
    
    public BrowseBookController() {
    }
    
   
    public ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ModelAndView mv = null;
        String searchKey =req.getParameter("by");
        String searchValue=req.getParameter("key");
        String uname = req.getParameter("uname");
        List<Book> results = null;
         BookDAO bookdao =new BookDAO();
        if(searchKey.equals("seller")){
                
                results = bookdao.searchBookbySeller(searchValue);
                
                 mv = new ModelAndView("Result","book",results);
                 
                 mv.addObject("key", searchValue);
            
            } else if(searchKey.equals("all")){
                
                results = bookdao.searchBookbyAll(searchValue);
                
                 mv = new ModelAndView("Result2","book",results);
            mv.addObject("key", searchValue);
            mv.addObject("uname", uname);
                
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