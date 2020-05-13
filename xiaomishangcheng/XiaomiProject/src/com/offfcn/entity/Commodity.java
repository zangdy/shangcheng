package com.offfcn.entity;

import java.util.Date;

public class Commodity {
	
	private Integer id;
	private Integer cid;
	private String name;
	private String color;
	private String size;
	private Double price;
	private String description;
	private String full_description;
	private String pic;
	private Integer state;  //1 普通 2热门 3推荐 4新品 5明星
	private String version;
	private Date product_date;
	//多来一个字符串作为 分类的名称封装使用
	private String cname;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFull_description() {
		return full_description;
	}
	public void setFull_description(String full_description) {
		this.full_description = full_description;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	public Commodity(Integer id, Integer cid, String name, String color, String size, Double price, String description,
			String full_description, String pic, Integer state, String version, Date product_date) {
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
		this.description = description;
		this.full_description = full_description;
		this.pic = pic;
		this.state = state;
		this.version = version;
		this.product_date = product_date;
	}
	public Commodity() {
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	

}
