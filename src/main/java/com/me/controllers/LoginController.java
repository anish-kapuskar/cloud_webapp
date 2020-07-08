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

import com.me.model.Login;
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

import com.timgroup.statsd.StatsDClient;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;


@Controller
public class LoginController {

  @Autowired
  private StatsDClient statsDclient;

  @Autowired
  UserService userService;
  @RequestMapping(value = "login.htm", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }
  @RequestMapping(value = "loginProcess.htm", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("login") Login login) {
    StopWatch stopwatch = StopWatch.createStarted();

    ModelAndView mav = null;
    User user = userService.validateUser(login);
    if (null != user) {
      mav = new ModelAndView("welcome2");
      mav.addObject("firstname", user.getFirstname());
      mav.addObject("lastname", user.getLastname());
      mav.addObject("email", user.getEmail());
      stopwatch.stop();
      statsDclient.recordExecutionTime("timeToLogin", stopwatch.getTime());
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
}
