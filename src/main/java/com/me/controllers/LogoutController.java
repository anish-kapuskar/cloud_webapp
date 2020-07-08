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

import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timgroup.statsd.StatsDClient;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;






@Controller
public class LogoutController {

    @Autowired
    private StatsDClient statsDclient;

    @Autowired
    UserService userService;
    @RequestMapping(value = "logout.htm", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        StopWatch stopwatch = StopWatch.createStarted();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        stopwatch.stop();
        statsDclient.recordExecutionTime("timeToLogout", stopwatch.getTime());
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
