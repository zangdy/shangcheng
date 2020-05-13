package com.offfcn.servleet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offfcn.common.PageBean;
import com.offfcn.service.UserService;

//针对当前的用户servlet 可以支持多个路径匹配
@WebServlet(value= {"/userServlet","/login"},loadOnStartup=1)
@MultipartConfig
public class UserServlet extends HttpServlet {

	
	@Override
	public void destroy() {
		System.out.println("servlet被销毁了");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlt被初始化了");
	}
	
	private UserService userService = new UserService();
	
	//专门处理用户请求的方法 但是用户的请求有多种 比如 登陆和注册就两种
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//先获取用户的操作标识
		String flag = req.getParameter("flag");
		//根据flag判断执行的操作逻辑
		if(flag.equals("adminLogin")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			// result为数值 如果返回为 0 表示账号密码不对1 表示权限不足 2表示登陆成功
			int result = userService.login(username,password,req.getSession());
			if(result==0) {
				
				req.setAttribute("msg", "您账号密码有误..");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}else if(result==1) {
				req.setAttribute("msg", "您不是管理员不允许登陆..");
					req.getRequestDispatcher("login.jsp").forward(req, res);
			}else  {
				//登陆成功 跳转main的jsp
				/* 转发一次请求  重定向两次
				 * 转发服务器  重定向客户端浏览器做
				 * 转发数据携带  重定向数据丢失
				 * 转发地址不变化  重定向地址栏发生改变
				 * 
				 * */
				res.sendRedirect("main.jsp");
			}
		}else if(flag.equals("logout")) {
			
			req.getSession().removeAttribute("username");
			res.sendRedirect("login.jsp");
		}else if(flag.equals("findAllUser")) {
			
			String pageNum = req.getParameter("pageNum");
			String pageSize = req.getParameter("pageSize");
			//使用分页的两个参数实现查询
			PageBean pb = userService.findUserByPage(pageNum,pageSize);
			//返回list页面
			req.setAttribute("pb", pb);
			req.getRequestDispatcher("user_list.jsp").forward(req, res);
		}else if(flag.equals("batchDelete")) {
			String ids = req.getParameter("deleteIds");
			boolean result = userService.deleteByIds(ids);
			res.getWriter().write(""+result);
		}
		
	}
	
	
	
	

}
