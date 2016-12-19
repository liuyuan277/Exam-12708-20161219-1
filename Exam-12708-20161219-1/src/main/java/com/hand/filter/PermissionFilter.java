package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PermissionFilter implements Filter {


    public PermissionFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session=req.getSession();
		String onlineUser=(String)session.getAttribute("OnLineUser");
		System.out.println("PermissionFilter" +onlineUser);
		String servletPath = req.getServletPath();
		System.out.println("Servlet Path ==> " + servletPath);
		
		//权限校验
		if (servletPath != null
				&& (servletPath.equals("/index.jsp")||servletPath.equals("/error.jsp")||servletPath.equals("/loginChatServlet"))){
			System.out.println("访问登录页面时");
			chain.doFilter(req, resp);
		}else{
			if(onlineUser!= null){
				chain.doFilter(req, resp);
			
			}else{
				req.setAttribute("msg", "您尚未登陆！<br/>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);	
			}
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("INIT PermissionFilter");
	}

}
