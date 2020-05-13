package com.offfcn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.offfcn.dao.ComodityDao;
import com.offfcn.dao.TrolleyDao;
import com.offfcn.entity.Category;
import com.offfcn.entity.Commodity;
import com.offfcn.entity.Trolley;
import com.offfcn.entity.User;

public class TrolleyService {
	
	TrolleyDao trolleyDao = new TrolleyDao();
	
	ComodityDao comDao = new ComodityDao();


	//接收servlet调用传递的商品id 组装购物车数据存储数据库
	public int saveTrollery(HttpServletRequest req) {
		String cid = req.getParameter("cid");
		User user = (User) req.getSession().getAttribute("user");
		//获取到登陆用户的id
		Trolley trolley = new Trolley(null,Integer.parseInt(cid),user.getId(),1,"");
		//在保存购物车数据之前先查询是否已经购买过该商品并且未生成订单
		Trolley dbTrolley = trolleyDao.findByCidAndUid(cid,user.getId());
		int i =0;
		if(null!=dbTrolley) {
			//如果数据库确实存在该商品添加的记录 不走保存 走修改
			int count = dbTrolley.getC_count();
			//使用原始数量增加1个再更新到数据库
			trolley = new Trolley(dbTrolley.getId(),Integer.parseInt(cid),user.getId(),count+1,""); 
			i = trolleyDao.updateTrolley(trolley);
			return i;
			
		}else {
			i = trolleyDao.saveTrolley(trolley);
		}
		
		return i;
		
	}

	
	public Long findTotalTrolley(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
		if(user==null) {
			return 0l;
		}
		return trolleyDao.findTotalTrolley(user.getId());
	}


	public List<Trolley> findTrolleyList(Integer uid) {
		
		//先查询数据库中当前用户的所有未生成订单的购物车记录
		List<Trolley> list = trolleyDao.findTrolleyList(uid);
		//将list中的每个购物车的商品属性赋值
		if(null!=list&&list.size()>0) {
			for(Trolley t:list) {
				//获取每个购物车对应的商品id
				Integer cid = t.getCid();
				//根据商品id得到对应的对象信息 返回
				Commodity com = comDao.findbyId(cid+"");
				t.setCommodity(com);
			}
		}
		return list;
	}


	public int updateNumByid(String idStr, String numStr) {
		Integer id = Integer.parseInt(idStr);
		Integer num = Integer.parseInt(numStr);
		int i = trolleyDao.updateNumByid( id, num);
		
		return i;
	}
	
	
}
