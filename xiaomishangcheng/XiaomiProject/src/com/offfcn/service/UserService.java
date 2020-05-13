package com.offfcn.service;

import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.offfcn.dao.UserDao;
import com.offfcn.entity.User;
import com.offfcn.util.SendSmsUtil;

public class UserService {

	//定义dao的类
	private UserDao userDao = new UserDao();
	
	public boolean saveUser(HttpServletRequest req) {
		//获取前端请求的所有用户信息 
		String name = req.getParameter("name");
		//性别使用数值代替 1男 0女
		String sex = req.getParameter("sex");
		String phone_number = req.getParameter("phone_number");
		String area = req.getParameter("area");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String photo = (String) req.getAttribute("photo");
		//组装user对象
		User user = new User(name,Integer.parseInt(sex),phone_number,
				area,username,password,photo,new Date());
		//调用dao的方法实现用户的存储
		return userDao.saveUser(user);
	}
	

	public boolean findByPhone(String phone) {
		
		User user = userDao.findByPhone(phone);
		if(null!=user) {
			return false;
		}
		
		return true;
	}


	public boolean findByName(String username) {
		User user = userDao.findByName(username);
		if(null!=user) {
			return false;
		}
		
		return true;
	}


	//调用发送短信的工具类得到发送的结果
	public boolean sendSms(String phone,HttpSession session) {
		String result = SendSmsUtil.sendSms(phone,session);
		if(result.equals("OK")) {
			return true;
		}
		return false;
	}


	public User findUserByPhone(String phone) {
		User user = userDao.findByPhone(phone);
		return user;
	}
}
