/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.DAO.CartDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Lord Aegon
 */
public class DeleteCartController extends AbstractController {

    public DeleteCartController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        CartDAO cartdao = new CartDAO();
        String option = request.getParameter("option");
        if(option ==null || option.isEmpty())
        {
            mv= new ModelAndView("ResultCart");
        }
        else
        {
            int id = Integer.parseInt(request.getParameter("id"));
            int result=cartdao.deleteCartById(id);
            if (result==1){
                mv= new ModelAndView("deleteSuccess","message","Book Removed from Cart!");
                logger.info("Delete successful");
            }
            else{
                mv= new ModelAndView("deleteError","message","Could not remove!");
                logger.info("Delete not successful");
            }
        }



        return mv;
    }

}

