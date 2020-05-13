package com.offfcn.entity;

import java.util.Date;

public class User {
	
	 //主键
		private int id;
		//姓名
		private String name;
		//性别 1,男 0 ,代表女
		private int sex;
		//电话号码
		private String phone_number;
		//所在地区
		private String area;
		//是否为管理员 0,管理员 1,是用户
		private int manager=1;
		//账号
		private String username;
		//密码
		private String password;
		//头像信息
		private String photo;
		//创建时间
		private Date create_time;
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @return the sex
		 */
		public int getSex() {
			return sex;
		}
		/**
		 * @return the phone_number
		 */
		public String getPhone_number() {
			return phone_number;
		}
		/**
		 * @return the area
		 */
		public String getArea() {
			return area;
		}
		/**
		 * @return the manager
		 */
		public int getManager() {
			return manager;
		}
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @return the photo
		 */
		public String getPhoto() {
			return photo;
		}
		/**
		 * @return the create_time
		 */
		public Date getCreate_time() {
			return create_time;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @param sex the sex to set
		 */
		public void setSex(int sex) {
			this.sex = sex;
		}
		/**
		 * @param phone_number the phone_number to set
		 */
		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}
		/**
		 * @param area the area to set
		 */
		public void setArea(String area) {
			this.area = area;
		}
		/**
		 * @param manager the manager to set
		 */
		public void setManager(int manager) {
			this.manager = manager;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @param photo the photo to set
		 */
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		/**
		 * @param create_time the create_time to set
		 */
		public void setCreate_time(Date create_time) {
			this.create_time = create_time;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone_number=" + phone_number + ", area="
					+ area + ", manager=" + manager + ", username=" + username + ", password=" + password + ", photo="
					+ photo + ", create_time=" + create_time + "]";
		}
		/**
		 * 
		 */
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * @param name
		 * @param sex
		 * @param phone_number
		 * @param area
		 * @param username
		 * @param password
		 * @param photo
		 * @param create_time
		 */
		public User(String name, int sex, String phone_number, String area, String username, String password, String photo,
				Date create_time) {
			super();
			this.name = name;
			this.sex = sex;
			this.phone_number = phone_number;
			this.area = area;
			this.username = username;
			this.password = password;
			this.photo = photo;
			this.create_time = create_time;
		}
		

}
