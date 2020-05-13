package com.offfcn.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;
import com.offfcn.common.PageBean;
import com.offfcn.dao.UserDao;
import com.offfcn.entity.User;

public class UserService {

	//定义dao的类
	private UserDao userDao = new UserDao();

	//查询数据库登陆 返回状体数值标识
	public int login(String username, String password,HttpSession session) {
		User user = userDao.findByNameAndPassword(username,password);
		if(user==null) {
			return 0;
		}else {
			if(user.getManager()==1) {
				return 1;
			}else {
				//为了保证当前登陆的任意页面都可以获取到用户名 存储到session中
				session.setAttribute("username", user.getName());
				return 2;
			}
		}
	}

	//分页查询得到pabebean返回
	public PageBean findUserByPage(String pageNumStr, String pageSizeStr) {
		if(StringUtils.isNullOrEmpty(pageNumStr)||StringUtils.isNullOrEmpty(pageSizeStr)) {
			pageNumStr="1";
			pageSizeStr="5";
		}
		Integer pageNum = Integer.parseInt(pageNumStr);
		Integer pageSize = Integer.parseInt(pageSizeStr);
		if(pageNum<1) {
			pageNum=1;
		}
		//组装pageBean返回
		PageBean pb = new PageBean();
		pb.setPageNum(pageNum);
		pb.setPageSize(pageSize);
		//调用数据库得到
		Long totalCount = userDao.findTotalCount();
		pb.setTotalCount(totalCount);
		//计算得到
		Long totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		if(pageNum>totalPage) {
			pageNum=totalPage.intValue();
		}
		pb.setTotalPage(totalPage.intValue());
		//
		List<User> list  = userDao.findUserByPage(pageNum,pageSize);
		pb.setList(list);
		return pb;
	}

	//根据多个id的字符串删除数据
	public boolean deleteByIds(String ids) {
		
		/*String deleteIds = ids.substring(0,ids.length()-1);
		System.out.println(deleteIds);*/
		String [] deleteIds = ids.split(",");
		for(String id:deleteIds) {
			userDao.deleteUserByIds(id);
		}
		return true;
	}
	
	
}
