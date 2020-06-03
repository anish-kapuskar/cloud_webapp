/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.DAO.BookDAO;
import com.me.bean.Book;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author anish
 */
public class AddBooksController extends AbstractController{

   public ModelAndView doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       
       Book book =new Book();
      
     
      String isbn=req.getParameter("isbn");
      String title=req.getParameter("title");
      String authors=req.getParameter("authors");
      String date=req.getParameter("date");
      Integer quantity=Integer.parseInt(req.getParameter("quantity"));
      Double price =Double.parseDouble(req.getParameter("price"));
      String seller = req.getParameter("seller");
      String time = req.getParameter("time");
      
      book.setIsbn(isbn);
      book.setTitle(title);
      book.setAuthors(authors);
      book.setDate(date);
      book.setQuantity(quantity);
      book.setPrice(price);
      book.setSeller(seller);
      book.setTime(time);

      BookDAO bookDao = new BookDAO();
      bookDao.addBook(book);
      ModelAndView mv=new ModelAndView("AddedBook");
      logger.info("Book has been added");
       return mv;
   }

   @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       return doPost(hsr,hsr1);
        
    }
}
