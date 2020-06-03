/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.DAO.BookDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Lord Aegon
 */
public class DeleteBookController extends AbstractController {
    
    public DeleteBookController() {
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
        else
        {
           int id = Integer.parseInt(request.getParameter("id"));
           int result=bookdao.deleteBookById(id);
           if (result==1){
           mv= new ModelAndView("deleteSuccess","message","Book Deleted!");
            logger.info("Delete successful");
           }
           else{
               mv= new ModelAndView("deleteError","message","Could not Delete!");
                logger.info("Delete not successful");
           }
        }
       
        
     
        return mv;
    }
    
}

