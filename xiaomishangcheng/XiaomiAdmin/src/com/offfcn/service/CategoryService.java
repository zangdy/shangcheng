package com.offfcn.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.StringUtils;
import com.offfcn.common.PageBean;
import com.offfcn.dao.CategoryDao;
import com.offfcn.entity.Category;

public class CategoryService {
	
	CategoryDao categoryDao = new CategoryDao();

	//根据分页的两个参数查询数据 组装分页的pageBean返回给servlet调用方
	public PageBean findCategoryPage(String pageNumStr, String pageSizeStr) {
		//初始化一个分页的对象用于返回
		PageBean pb = new PageBean();
		//分页的两个参数做判断 是否有效
		if(StringUtils.isNullOrEmpty(pageNumStr)||StringUtils.isNullOrEmpty(pageSizeStr)){
			pageNumStr="1";
			pageSizeStr="3";
		}
		Integer pageNum =Integer.parseInt(pageNumStr);
		Integer pageSize = Integer.parseInt(pageSizeStr);
		if(pageNum<1) {
			pageNum=1;
		}
		
		//调用dao使用统计函数得到表中的所有记录
		Long totalCount = categoryDao.findTotalCount();
		pb.setTotalCount(totalCount);
		//计算得到总页数
		Long totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		//如果当前页大于总页数 让当前页查询最后一页
		if(pageNum>totalPage) {
			pageNum=totalPage.intValue();
		}
		pb.setPageNum(pageNum);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage.intValue());
		//最后一个参数list是数据库得到的分页结果集合
		//分页查询使用的两个参数 pageNum  pageSize  
		//select * from category limit ? ,? 
		List<Category> list = categoryDao.findCategoryList(pageNum,pageSize);
		pb.setList(list);
		
		
		return pb;
	}

	//保存的service方法
	public boolean saveCategory(HttpServletRequest req) {
		
		String name = req.getParameter("name");
		String order_number = req.getParameter("order_number");
		String description = req.getParameter("description");
		String status = req.getParameter("status");
		Category cate = new Category(null,name,
									Integer.parseInt(status),
									Integer.parseInt(order_number),
									description,new Date());
		int i = categoryDao.saveCategory(cate);
		if(i>0) {
			return true;
		}
		return false;
	}

	//调用dao得到对象返回给servlet
	public Category findById(String id) {
		
		
		return categoryDao.findbyId(id);
	}

	
	public boolean updateCategory(HttpServletRequest req) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String order_number = req.getParameter("order_number");
		String description = req.getParameter("description");
		String status = req.getParameter("status");
		Category cate = new Category(Integer.parseInt(id),name,
									Integer.parseInt(status),
									Integer.parseInt(order_number),
									description,new Date());
		int i = categoryDao.updateCategory(cate);
		if(i>0) {
			return true;
		}
		return false;
	}

	public boolean deleteById(String id) {
		int i = categoryDao.deleteById(id);
		return i>0?true:false;
	}

	
	public List<Category> findAllCategory() {
		
		return categoryDao.findAll();
	}

	
	
}
