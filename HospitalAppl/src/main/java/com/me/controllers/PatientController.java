/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author anish
 */
public class PatientController extends AbstractController {
    
    public PatientController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            ModelAndView mv = null;
        String option = request.getParameter("option");
        if(option !=null && option.equalsIgnoreCase("Patient Registration"))
        {
            mv= new ModelAndView("AddPatient");
        }
        else if(option !=null && option.equalsIgnoreCase("Retrieve Patient Details"))
        {
            mv= new ModelAndView("BrowsePatient");
        }
        else
        {
       
            mv = new ModelAndView("Welcome");
        }
        
     
        return mv;
    }
    
}
