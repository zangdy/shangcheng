package com.offfcn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offfcn.entity.Commodity;

public class ComodityDao {
	
	//c3p0数据源       
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//QueryRunner
	QueryRunner qr = new QueryRunner(dataSource);

	//统计总数量
	public Long findTotalCount() {
		String sql ="select count(*) totalCount from commodity";
		try {
			Map map = qr.query(sql, new MapHandler());
			Long totalCount =(Long)map.get("totalCount");
			return totalCount;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	//使用分页的两个参数查询得到list集合
	public List<Commodity> findCommodityList(Integer pageNum, Integer pageSize) {
		String sql = " SELECT c.*,g.name cname FROM commodity c ,category g WHERE c.cid=g.id   limit ? ,?";
		Integer startIndex =(pageNum-1)*pageSize;
		Integer [] params =  {startIndex,pageSize};
		try {
			List<Commodity> list = qr.query(sql,params,new BeanListHandler<>(Commodity.class));
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	

	//查询单个对象返回
	public Commodity findbyId(String id) {
		String sql="select * from commodity where id = ?";
		try {
			return qr.query(sql,id,new BeanHandler<>(Commodity.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	//dao获取service传递对象中的参数 执行sql
		public int saveCommodity(Commodity com) {
			String sql = "INSERT INTO commodity VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				int i = qr.update(sql,com.getId(),com.getCid(),com.getName(),
								com.getColor(),com.getSize(),com.getPrice(),com.getDescription(),com.getFull_description(),
								com.getPic(),com.getState(),com.getVersion(),com.getProduct_date());
				return i;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return 0;
		}
	//更新记录的操作
	public int updateCommodity(Commodity com) {
		String sql = "update commodity set cid=?,name=?,color=?,size=?,price=?,"
				+ "description=?,full_description=?,pic=?,state=?,version=? where id = ?";
		try {
			int i = qr.update(sql,com.getCid(),com.getName(),
					com.getColor(),com.getSize(),com.getPrice(),com.getDescription(),com.getFull_description(),
					com.getPic(),com.getState(),com.getVersion(),com.getId());
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	//执行sql删除
	public int deleteById(String id) {
		String sql = "delete from commodity where id  = ?";
		try {
			int i = qr.update(sql,id);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Commodity> findCommodityByState(Integer  state,Integer size) {
		Integer [] params = {state,size};
		try {
			return qr.query("select * from commodity where state= ? limit ? ",params,new BeanListHandler<>(Commodity.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Commodity> findCommodityListByCate(int cateId, int size) {
	
		Integer [] params = {cateId,size};
		try {
			return qr.query("select * from commodity where cid= ? limit ? ",params,new BeanListHandler<>(Commodity.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public List<Commodity> findListByKeyWords(String sql, int size) {
		
		try {
			return qr.query(sql,size,new BeanListHandler<>(Commodity.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}
