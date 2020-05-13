package com.offfcn.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offfcn.entity.User;

public class UserDao {
	
	//c3p0数据源       
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//QueryRunner
	QueryRunner qr = new QueryRunner(dataSource);
	
	//保存用户到数据库的方法
	public boolean saveUser(User user) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
	
		try {
			int i = qr.update(sql,null,user.getName(),user.getSex(),user.getPhone_number(),
					user.getArea(),user.getManager(),user.getUsername(),user.getPassword(),
					user.getPhoto(),user.getCreate_time());
			System.out.println(i);
			
			return i>0?true:false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	

	public User findByPhone(String phone) {
		String sql = "select * from  user where phone_number = ?" ;
		try {
			return qr.query(sql,phone, new BeanHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	public User findByName(String username) {
		String sql = "select * from  user where username = ?" ;
		try {
			return qr.query(sql,username, new BeanHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
