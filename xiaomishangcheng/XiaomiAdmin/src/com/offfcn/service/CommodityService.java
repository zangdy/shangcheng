package com.offfcn.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.StringUtils;
import com.offfcn.common.PageBean;
import com.offfcn.dao.ComodityDao;
import com.offfcn.entity.Commodity;

public class CommodityService {
	
	ComodityDao commodityDao = new ComodityDao();

	//根据分页的两个参数查询数据 组装分页的pageBean返回给servlet调用方
	public PageBean findComodityPage(String pageNumStr, String pageSizeStr) {
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
		Long totalCount = commodityDao.findTotalCount();
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
		//select * from Commodity limit ? ,? 
		List<Commodity> list = commodityDao.findCommodityList(pageNum,pageSize);
		pb.setList(list);
		
		return pb;
	}

	

	//调用dao得到对象返回给servlet
	public Commodity findById(String id) {
		
		
		return commodityDao.findbyId(id);
	}

	


	public boolean deleteById(String id) {
		int i = commodityDao.deleteById(id);
		return i>0?true:false;
	}



	public boolean save(HttpServletRequest req) {
		
		String cid = req.getParameter("cid");
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		String full_description = req.getParameter("full_description");
		String pic = (String) req.getAttribute("pic");
		String state = req.getParameter("state");
		String version = req.getParameter("version");
		int i = commodityDao.saveCommodity(new Commodity(null, Integer.parseInt(cid), name, color, size, 
												Double.parseDouble(price), description, full_description, 
												pic, Integer.parseInt(state), version, new Date()));
		return i>0?true:false;
	}



	
	public boolean update(HttpServletRequest req) {
		String id = req.getParameter("id");
		String cid = req.getParameter("cid");
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		String full_description = req.getParameter("full_description");
		String pic = (String) req.getAttribute("picOld");
		String state = req.getParameter("state");
		String version = req.getParameter("version");
		int i = commodityDao.updateCommodity(new Commodity(Integer.parseInt(id), Integer.parseInt(cid), name, color, size, 
												Double.parseDouble(price), description, full_description, 
												pic, Integer.parseInt(state), version, new Date()));
		return i>0?true:false;
	}

	
	
}
