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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author anish
 */
public class DisplayCartController extends AbstractController {

    public DisplayCartController() {
    }


    public ModelAndView doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ModelAndView mv = null;
        String searchKey =req.getParameter("by");
        String searchValue=req.getParameter("key");
        String uname = req.getParameter("uname");
        List<Cart> results = null;
        CartDAO cartdao =new CartDAO();
        if(searchKey.equals("buyer")){

            results = cartdao.searchCartbyBuyer(searchValue);

            mv = new ModelAndView("ResultCart","cart",results);

            mv.addObject("key", searchValue);
            mv.addObject("uname",uname);

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