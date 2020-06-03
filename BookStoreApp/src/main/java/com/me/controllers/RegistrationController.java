/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

/**
 *
 * @author Lord Aegon
 */

import com.me.model.User;
import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;

  @RequestMapping(value = "register.htm", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    return mav;
  }
  @RequestMapping(value = "registerProcess.htm", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                              @ModelAttribute("user") User user) {
    userService.register(user);

    ModelAndView mav2 = new ModelAndView("welcome2");
    mav2.addObject("firstname", user.getFirstname());
    mav2.addObject("lastname", user.getLastname());
    mav2.addObject("email", user.getEmail());
    mav2.addObject("user", user);

    return mav2;

  }



  @RequestMapping(value = "update.htm", method = RequestMethod.POST)
  public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) {
    String username = request.getParameter("username");
    ModelAndView mav = new ModelAndView("update");
    mav.addObject("user", new User());
    mav.addObject("username", username);
    return mav;
  }

  @RequestMapping(value = "updateProcess.htm", method = RequestMethod.POST)
  public ModelAndView updateProcessUser(HttpServletRequest request, HttpServletResponse response,
                              @ModelAttribute("user") User user) {
    userService.update(user);

    ModelAndView mav2 = new ModelAndView("welcome2");
    mav2.addObject("firstname", user.getFirstname());
    mav2.addObject("lastname", user.getLastname());
    mav2.addObject("email", user.getEmail());
    mav2.addObject("user", user);

    return mav2;

  }

}