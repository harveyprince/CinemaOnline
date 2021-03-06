package com.cinemaonline.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport implements SessionAware,  
        ServletRequestAware, ServletResponseAware {  
  
    private static final long serialVersionUID = 1L;  
    protected static final String WELCOME = "welcome";
    protected static final String AJAXINFO = "ajaxinfo";
    protected static final String STATISTICAGE = "statisticage";
    protected static final String STATISTICSEX = "statisticsex";
    protected static final String STATISTICLOCATION = "statisticlocation";
    protected static final String STATISTICCARD = "statisticcard";
    protected static final String STATISTICCINEMA = "statisticcinema"; 
    public HttpServletRequest   request;  
    public HttpServletResponse  response;  
    @SuppressWarnings("unchecked")  
    public Map session;  
  
    public void setSession(Map session) {  
        this.session = session;  
    }  
  
    public void setServletRequest(HttpServletRequest request) {  
       this.request = request;  
    }  
  
    public void setServletResponse(HttpServletResponse response) {  
       this.response = response;  
    }}

