package com.offfcn.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offfcn.entity.Orders;

public class OrderDao {

	//c3p0数据源       
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//QueryRunner
	QueryRunner qr = new QueryRunner(dataSource);
	
	public int saveOrder(Orders order) {
		
		String sql ="insert into orders values(?,?,?,?,?,?,?)";
	    try {
			int i = qr.update(sql,order.getId(),order.getOrder_num(),order.getUid(),order.getOrder_money(),order.getState()
					 ,order.getCreate_time(),order.getC_count());
			return i;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public int updateStateByNum(String orderNum) {
		
		String sql = "update orders set state = 2 where order_num = ?";
		try {
			int i = qr.update(sql,orderNum);
			return i;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

}
