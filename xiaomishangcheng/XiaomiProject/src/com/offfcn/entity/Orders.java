package com.offfcn.entity;

import java.util.Date;

public class Orders {
	
	private Integer id;
	private String order_num;
	private Integer uid;
	private Double order_money;
	private Integer state;
	private Date create_time;
	private Integer c_count;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Double getOrder_money() {
		return order_money;
	}
	public void setOrder_money(Double order_money) {
		this.order_money = order_money;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getC_count() {
		return c_count;
	}
	public void setC_count(Integer c_count) {
		this.c_count = c_count;
	}
	public Orders(Integer id, String order_num, Integer uid, Double order_money, Integer state, Date create_time,
			Integer c_count) {
		super();
		this.id = id;
		this.order_num = order_num;
		this.uid = uid;
		this.order_money = order_money;
		this.state = state;
		this.create_time = create_time;
		this.c_count = c_count;
	}
	public Orders() {
		super();
	}
	
	

}
