package com.offfcn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offfcn.entity.Category;
import com.offfcn.entity.Trolley;

public class TrolleyDao {
	
	//c3p0数据源       
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//QueryRunner
	QueryRunner qr = new QueryRunner(dataSource);

	

	//dao获取service传递对象中的参数 执行sql
	public int saveTrolley(Trolley tro) {
		String sql = "INSERT INTO trolley VALUES(?,?,?,?,?)";
		
		try {
			int i = qr.update(sql,tro.getId(),tro.getCid(),tro.getUid(),tro.getC_count(),
					tro.getOrder_num() );
			return i;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}


	public Trolley findByCidAndUid(String cid, int uid) {
		//多加个条件 判断是否生成过订单 未生成过的提取出来
		String sql = "select * from trolley where cid = ? and uid =? and order_num='' ";
		String [] params= {cid,uid+""};
		try {
			Trolley trolley = qr.query(sql,params,new BeanHandler<>(Trolley.class));
			return trolley;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public int updateTrolley(Trolley trolley) {
		String sql = "update trolley set cid=?,uid=?,c_count=?,order_num=? where id = ?";
		
		try {
			int i = qr.update(sql,trolley.getCid(),trolley.getUid(),trolley.getC_count(),trolley.getOrder_num(),
					trolley.getId());
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	//根据用户id 和未生成的订单号统计当前用户的总数量
	public Long findTotalTrolley(Integer uid) {
		String sql = "SELECT COUNT(*) totalCount FROM trolley WHERE uid =? AND order_num = ''";
		try {
			Map<String, Object> map = qr.query(sql,uid, new MapHandler() );
			return (Long) map.get("totalCount");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0l;
	}


	public List<Trolley> findTrolleyList(Integer uid) {
		
		String sql = "SELECT * FROM trolley WHERE uid =? AND order_num = ''";
		 List<Trolley> list = null;
		try {
			list = qr.query(sql,uid, new BeanListHandler<>(Trolley.class));
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	public int updateNumByid(Integer id, Integer num) {
		
		String sql = "update trolley set c_count = c_count+? where id= ?";
		try {
			int i = qr.update(sql,num,id);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	
	public int updateOrderNum(String orderNum,Integer uid) {
		String sql = "update trolley set order_num = ? where uid=? ";
		try {
			int i = qr.update(sql,orderNum,uid);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	
}
