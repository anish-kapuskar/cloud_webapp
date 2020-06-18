/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.DAO.BookDAO;
import com.me.bean.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Lord Aegon
 */
public class UpdateBookController extends AbstractController {
    
    public UpdateBookController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            ModelAndView mv = null;
                    BookDAO bookdao = new BookDAO();
        String option = request.getParameter("option");
        if(option ==null || option.isEmpty()) 
        {
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
      
      int result=bookdao.updateBook(id,isbn, title, authors, date, quantity, price, seller,time);
      
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
} 
        
     
       
    
    

