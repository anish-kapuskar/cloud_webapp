/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;
import com.me.DAO.CartDAO;
import com.me.bean.Cart;
import com.me.DAO.BookDAO;
import com.me.bean.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.List;

import com.timgroup.statsd.StatsDClient;
import org.apache.log4j.Logger;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author Lord Aegon
 */
public class CartController extends AbstractController {

    private static final Logger logger=Logger.getLogger(CartController.class);
    @Autowired
    private StatsDClient statsDclient;

    public CartController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        StopWatch stopwatch = StopWatch.createStarted();

        ModelAndView mv = null;

        Cart cart = new Cart();


        BookDAO bookdao = new BookDAO();

        String searchKey =request.getParameter("by");
        String searchValue=request.getParameter("key");

        List<Cart> results = null;

        String option = request.getParameter("option");
        String uname = request.getParameter("uname");

        if(option ==null || option.isEmpty())
        {
            statsDclient.incrementCounter("viewListing");
            logger.info("viewing listing");
            mv= new ModelAndView("Result2");
            stopwatch.stop();
            statsDclient.recordExecutionTime("viewListing", stopwatch.getTime());
        }
        else if(option.equalsIgnoreCase("cart"))
        {
            statsDclient.incrementCounter("viewBook");
            logger.info("viewing book");

            int id = Integer.parseInt(request.getParameter("id"));
            Book cartBook = bookdao.getBookById(id);
            mv= new ModelAndView("cartBook","message", cartBook);
            mv.addObject("uname", uname);
            stopwatch.stop();
            statsDclient.recordExecutionTime("viewBook", stopwatch.getTime());
        }
        else if(option.equalsIgnoreCase("cartBook")){
            String isbn=request.getParameter("isbn");
            String title=request.getParameter("title");
            String authors=request.getParameter("authors");
            String date=request.getParameter("date");
            Integer quantity=Integer.parseInt(request.getParameter("quantity"));
            Double price =Double.parseDouble(request.getParameter("price"));
            String buyer = request.getParameter("buyer");
            String time = request.getParameter("time");

            cart.setIsbn(isbn);
            cart.setTitle(title);
            cart.setAuthors(authors);
            cart.setDate(date);
            cart.setQuantity(quantity);
            cart.setPrice(price);
            cart.setBuyer(buyer);
            cart.setTime(time);

            CartDAO cartdao = new CartDAO();
            cartdao.addCart(cart);
             mv=new ModelAndView("cartAdded","message","Book Added to Cart!");
            mv.addObject("uname", uname);
            logger.info("Book has been added");
            stopwatch.stop();
            statsDclient.recordExecutionTime("bookAddedToCart", stopwatch.getTime());
            return mv;

        }
        else if(option.equalsIgnoreCase("viewCart")){
            mv=new ModelAndView("viewCart");
            mv.addObject("uname", uname);
            stopwatch.stop();
            statsDclient.recordExecutionTime("viewCart", stopwatch.getTime());
        }


        return mv;
    }
}






