package com.offfcn.entity;

public class Trolley {
	
	private Integer id;
	private Integer cid;
	private Integer uid;
	private Integer c_count;
	private String order_num;
	//多定义一个属性作为商品对象返回前端浏览器
	private Commodity commodity;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getC_count() {
		return c_count;
	}
	public void setC_count(Integer c_count) {
		this.c_count = c_count;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public Trolley(Integer id, Integer cid, Integer uid, Integer c_count, String order_num) {
		super();
		this.id = id;
		this.cid = cid;
		this.uid = uid;
		this.c_count = c_count;
		this.order_num = order_num;
	}
	public Trolley() {
		super();
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	
	
	

}
