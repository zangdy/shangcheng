package com.offfcn.service;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.offfcn.dao.OrderDao;
import com.offfcn.dao.TrolleyDao;
import com.offfcn.entity.Orders;
import com.offfcn.entity.User;

public class OrderService {
	
	private OrderDao orderDao = new OrderDao();
	
	private TrolleyDao trolleyDao = new TrolleyDao();

	public int saveOrder(String totalCount, String totalMoney,HttpServletRequest req,String orderNum) {
		
		
		User user = (User) req.getSession().getAttribute("user");
		Orders order = new Orders(null,orderNum,user.getId(),
				     Double.parseDouble(totalMoney),1,new Date(),Integer.parseInt(totalCount));
		//使用订单号 和当前登陆用户的id 更新购物车的表数据
		int i = trolleyDao.updateOrderNum(orderNum,user.getId());
		System.out.println(i+"-----更新的购车记录数量");
		//调用dao 将order作为参数执行sql插入
		return orderDao.saveOrder(order);
	}

	public int updateStateByNum(String orderNum) {
		
		
		
		return orderDao.updateStateByNum(orderNum);
	}

}
