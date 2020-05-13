package com.offfcn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offfcn.entity.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserDao {
	
	//c3p0数据源       
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//QueryRunner
	QueryRunner qr = new QueryRunner(dataSource);

	
	public User findByNameAndPassword(String username, String password) {
		String sql = "select * from user where username=? and password = ?";
		String [] params = {username,password};
		User user =null;
		try {
			user = qr.query(sql,params, new BeanHandler<>(User.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}


	//count函数得到总数量
	public Long findTotalCount() {
		String sql="select count(*) totalCount from user ";
		try {
			Map map = qr.query(sql, new MapHandler());
			return (Long) map.get("totalCount");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	public List<User> findUserByPage(Integer pageNum, Integer pageSize) {
		String sql = "select * from user limit ?,?";
		Integer startIndex = (pageNum-1)*pageSize;
		Integer [] params = {startIndex,pageSize};
		try {
			List<User> list = qr.query(sql, params,new BeanListHandler<>(User.class));
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	public boolean deleteUserByIds(String id) {
		String sql = "delete from user where id = ? ";
		try {
			int i = qr.update(sql,id);
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
