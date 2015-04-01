package com.cinemaonline.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RequestFilter
 */
@WebFilter(urlPatterns="/*")
public class RequestFilter implements Filter {

	public static final String[] vipurl = {"vipinfo","infoUpate","vipcard","activatecard","cardrecharge","scoreTranslate","disactivateCard","vip_record","viprecord","vip_activity","vip_old_activity","vipactivity","joinActivity","vipserver_ticket","vipticket","vipticketCheck","vipticketPay"};
	public static final String[] serverurl = {"server_film_plan","serverfilmplan","planedit","planadd","plansubmit","server_film","server_old_film","serverfilm",
			"filmadd","filmedit","releasefilm","unreleasefilm","server_activity","server_ended_activity","serveractivity","activityadd","activityedit","actpublish",
			"server_ticket","server_old_ticket","ticketsale","ticketCheck","ticketPay","server_vip_record","viewVipDetail"};
	public static final String[] managerurl = {"viewStatics","statisticjsonage","statisticjsonsex","statisticjsonlocation","statisticjsoncard","statisticjsoncinema","manar_filmplan","manar_old_filmplan","manager","planpass","planunpass"};
    /**
     * Default constructor. 
     */
    public RequestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		HttpSession session = httprequest.getSession();
		String url = httprequest.getRequestURI();
		boolean vipmatch = match(vipurl,url);
		boolean servermatch = match(serverurl,url);
		boolean managermatch = match(managerurl,url);
		String userid = "";
		int identity = 0;
		if(vipmatch||servermatch||managermatch){
			try{
			userid = (String) session.getAttribute("userid");
			identity = (int) session.getAttribute("identity");
			if(userid==null||userid==""){
				httpresponse.sendRedirect("login");
			}else{
				switch(identity){
				case 1:
					if(!vipmatch){
						httpresponse.sendRedirect("login");
					}
					break;
				case 2:
					if(!servermatch){
						httpresponse.sendRedirect("login");
					}
					break;
				case 3:
					if(!managermatch){
						httpresponse.sendRedirect("login");
					}
					break;
				default:
					httpresponse.sendRedirect("login");
					break;
				}
			}
			}catch(Exception e){
				httpresponse.sendRedirect("login");
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
	public boolean match(String[] book,String obj){
		for(String temp:book){
			if(obj.indexOf("/CinemaOnline/"+temp)>=0){
				return true;
			}
		}
		return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
