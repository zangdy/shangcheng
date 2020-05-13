package com.offfcn.service;

import java.util.List;

import com.offfcn.dao.ComodityDao;
import com.offfcn.entity.Commodity;

public class CommodityService {
	
	ComodityDao commodityDao = new ComodityDao();

	
	public List<Commodity> findCommodityList(Integer state,Integer size) {
		//参数1表示查询的模块state
		//参数2表示查询的数量
		return commodityDao.findCommodityByState(state,size);
	}


	public List<Commodity> findCommodityListByCate() {
		//参数1表示查询的分类的id
		//参数2表示查询的数量
		return commodityDao.findCommodityListByCate(5,8);
	}


	//获取keyWords的字符串包含的所有关键词 每个关键词都作为查询条件
	public List<Commodity> findCommodityListByKeyWords(String keyWords, int size) {
		//小米6#小米5#红米note#
		String [] keys = keyWords.split("#");
		String sql = "SELECT * FROM commodity WHERE ";
		for(int i=0;i<keys.length;i++) {
			if(i==keys.length-1) {
				sql=sql+" NAME LIKE '%"+keys[i]+"%' ";
			}else {
				sql=sql+" NAME LIKE '%"+keys[i]+"%' "+" OR ";
			}
			
		}
		sql = sql+" limit ?";
		System.out.println("执行的sql语句为：======"+sql);	
		List<Commodity> list = commodityDao.findListByKeyWords(sql,size);
		return list;
	}


	
	public Commodity findById(String id) {
		
		return commodityDao.findbyId(id);
	}


	

	
}
