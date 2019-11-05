/**
 * @Title:Forum/com.forum.entity/User.java
 * @Description:
 */
package com.forum.entity;

import java.util.Date;

/**
 * @author kc
 * @Description: 用户实体
 * @Date: 2019年11月1日下午3:26:43
 * @version: 1.0
 */
public class User {
	private int id;
	
	private String mail;
	
	private String password;
	
	/*
	 * 昵称
	 */
	private String nickName;
	
	private int sex;
	
	private String phone;
	
	/*
	 * 金币
	 */
	private int gold;
	
	private String city;
	
	/*
	 * 签名
	 */
	private String signature;
	
	/*
	 * 头像路径
	 */
	private String avatar;
	
	private Date createTime;

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", password=" + password + ", nickName=" + nickName + ", sex="
				+ sex + ", phone=" + phone + ", gold=" + gold + ", city=" + city + ", signature=" + signature
				+ ", avatar=" + avatar + ", createTime=" + createTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	} 
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
