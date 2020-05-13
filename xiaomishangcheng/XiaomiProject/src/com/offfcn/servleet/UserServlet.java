package com.offfcn.servleet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offfcn.entity.Category;
import com.offfcn.entity.Commodity;
import com.offfcn.entity.User;
import com.offfcn.service.CategoryService;
import com.offfcn.service.CommodityService;
import com.offfcn.service.UserService;
import com.offfcn.util.UploadImg;

@WebServlet("/userServlet")
@MultipartConfig
public class UserServlet extends HttpServlet {

	private UserService userService = new UserService();
	
	//专门处理用户请求的方法 但是用户的请求有多种 比如 登陆和注册就两种
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//先获取用户的操作标识
		String flag = req.getParameter("flag");
		//根据flag判断执行的操作逻辑
		if(flag.equals("register")) {
			//先从req中获取需要被保存的文件二进制数据
			//part对象封装了浏览器传递的文件信息 比如 大小 名称 二进制数据内容
			Part part = req.getPart("photo");
			String fileName = "";
			//判断part文件是否存在
			if(part.getSize()>0) {
				
				fileName = UploadImg.uploadImg(part, req);
				if(!"".equals(fileName)) {
					req.setAttribute("photo", fileName);
				}else {
					req.setAttribute("msg", "文件上传失败 格式只支持jpg png");
					req.getRequestDispatcher("register.jsp").forward(req, res);
					return;
				}
			}
			
			//调用service的注册方法
			boolean result = userService.saveUser(req);
			if(result) {
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}else {
				req.setAttribute("msg", "注册失败");
				req.getRequestDispatcher("register.jsp").forward(req, res);
			}
		}else if(flag.equals("login")){
			//手机号 和 验证码匹配
			String phone = req.getParameter("phone_number");
			String code = req.getParameter("code");
			//去session中获取phone对应的code 和浏览器传递过来的code 比一比
			Integer sessionCode = (Integer) req.getSession().getAttribute(phone);
			if(code.equals(sessionCode+"")) {
				//如果用户登陆成功 为了存储登陆信息 首先获取数据库中 用户的对象 存入session
				User user = userService.findUserByPhone(phone);
				req.getSession().setAttribute("username", user.getName());
				req.getSession().setAttribute("user", user);
				//跳转index页面
				res.sendRedirect("indexServlet");
			}else {
				req.setAttribute("msg", "验证码不匹配");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
			//调用service的登陆方法
		}else if(flag.equals("checkPhone")) {
			String phone = req.getParameter("phoneNum");
			boolean result = userService.findByPhone(phone);
			res.getWriter().write(result+"");
		}else if(flag.equals("checkName")) {
			String username = req.getParameter("username");
			boolean result = userService.findByName(username);
			res.getWriter().write(result+"");
		}else if(flag.equals("checkUserByPhone")) {
			String phone = req.getParameter("phoneNum");
			boolean result = userService.findByPhone(phone);
			res.getWriter().write(result+"");
		}else if(flag.equals("sendSms")) {
			String phone = req.getParameter("phoneNum");
			boolean result = userService.sendSms(phone,req.getSession());
			res.getWriter().write(result+"");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID());
	}
	

}
