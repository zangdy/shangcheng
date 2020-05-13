package com.offfcn.filter;

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

import com.mysql.fabric.Response;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//判断当前请求的时候 session中是否存在用户名称 如果不存在调换logi.jsp
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession  session = request.getSession();
		if(session.getAttribute("username")!=null) {
			//用户名存在放行
			chain.doFilter(req, res);
		}else {
			//获取到当前req正在访问的url路径使什么
			String url = request.getRequestURI();
			StringBuffer requestURL = request.getRequestURL();
			String path = request.getServletPath();
			System.out.println(url);
			System.out.println(requestURL);
			System.out.println(path);
		    if(url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".jpg")
	                ||url.endsWith(".gif")||url.endsWith(".png")||url.endsWith("/login.jsp")||url.endsWith("/ok.html")||url.endsWith("login")){
				//用户名存在放行
				chain.doFilter(req, res);
			}else {
				HttpServletResponse response = (HttpServletResponse)(res);
				response.sendRedirect("login.jsp");


			}
			
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
