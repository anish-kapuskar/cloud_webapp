/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;
import java.util.logging.Logger;

/**
 *
 * @author anish
 */
public class SQLInjectionInterceptor implements HandlerInterceptor  {
        public String sanitize(String param) {
        param = param.replaceAll("#", "_");// to do and done changing get param to get attribute in controller
        param = param.replaceAll("<", "_");        
        param = param.replaceAll(">", "_");
        return param;
    }
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if(request.getParameter("searchValue") != null) {
            request.setAttribute("searchValue", sanitize(request.getParameter("searchValue")));
        }

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        if(name != null) {
            request.setAttribute("name", sanitize(name));
        }
        if(gender != null) {
            request.setAttribute("gender", sanitize(gender));
        }
        if(email != null) {
            request.setAttribute("email", sanitize(email));
        }
        if(phone != null) {
            request.setAttribute("phone", sanitize(phone));
        }
        if(date != null) {
            request.setAttribute("date", sanitize(date));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {
        response.getWriter().println("Sanitized post handle");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
         hsr1.getWriter().println("Sanitized after completion");

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



