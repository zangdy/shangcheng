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

public class CategoryDao {
	
	//c3p0数据源       
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//QueryRunner
	QueryRunner qr = new QueryRunner(dataSource);

	//统计总数量
	public Long findTotalCount() {
		String sql ="select count(*) totalCount from category";
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
	public List<Category> findCategoryList(Integer pageNum, Integer pageSize) {
		String sql = "select * from category order by order_number  limit ? ,?";
		Integer startIndex =(pageNum-1)*pageSize;
		Integer [] params =  {startIndex,pageSize};
		try {
			List<Category> list = qr.query(sql,params,new BeanListHandler<>(Category.class));
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	//dao获取service传递对象中的参数 执行sql
	public int saveCategory(Category cate) {
		String sql = "INSERT INTO category VALUES(?,?,?,?,?,?)";
		
		try {
			int i = qr.update(sql,cate.getId(),cate.getName(),cate.getState(),cate.getOrder_number(),
					                           cate.getDescription(),cate.getCreate_time());
			return i;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	//查询单个对象返回
	public Category findbyId(String id) {
		String sql="select * from category where id = ?";
		try {
			return qr.query(sql,id,new BeanHandler<>(Category.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	//更新记录的操作
	public int updateCategory(Category cate) {
		String sql = "update category set name=?,state=?,order_number=?,description=? where id = ?";
		try {
			int i = qr.update(sql,cate.getName(),cate.getState(),cate.getOrder_number(),cate.getDescription(),cate.getId());
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	//执行sql删除
	public int deleteById(String id) {
		String sql = "delete from category where id  = ?";
		try {
			int i = qr.update(sql,id);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public List<Category> findAll() {
		//分类只允许查询10条
		String sql = "select * from category where state = 0 limit 0,10 ";
		//String sql = "select * from category where state = 0 limit 10 ";
		List<Category> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Category.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	
	
	
}
