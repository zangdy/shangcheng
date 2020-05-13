package com.offfcn.entity;

import java.util.Date;

public class Category {
	
	
	private Integer id;
	private String name;
	private Integer state ;              //表示分类的状体 是否可用
	private Integer order_number ;       //排序的字段 数值越小越靠前
	private String description;  //文字描述
	private Date create_time;      //创建时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrder_number() {
		return order_number;
	}
	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Category(Integer id, String name, Integer state, Integer order_number, String description,
			Date create_time) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.order_number = order_number;
		this.description = description;
		this.create_time = create_time;
	}
	public Category() {
		super();
	}
	
	
	

}
