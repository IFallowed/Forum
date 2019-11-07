/**
2 * @Title:Forum/com.forum.entity/ThemePost.java
 * @Description:
 */
package com.forum.entity;

import java.util.Date;

/**
 * @author kc
 * @Description: 
 * @String: 2019年11月6日上午11:38:45
 * @version: 1.0
 */
public class ThemePost {
	
	private int id;
	private String title;
	private String Content;
	private User user;
	private String type;
	private String state;
	private int gold;
	private int browseNum;
	private int replyNum;
	private int collectNum;
	private Date createTime;
	private String timeDelay;
	
	@Override
	public String toString() {
		return "ThemePost [id=" + id + ", title=" + title + ", Content=" + Content + ", user=" + user + ", type=" + type
				+ ", state=" + state + ", gold=" + gold + ", browseNum=" + browseNum + ", replyNum=" + replyNum
				+ ", collectNum=" + collectNum + ", createTime=" + createTime + ", timeDelay=" + timeDelay + "]";
	}

	public String getTimeDelay() {
		return timeDelay;
	}
	
	public void setTimeDelay(String timeDelay) {
		this.timeDelay = timeDelay;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getBrowseNum() {
		return browseNum;
	}

	public void setBrowseNum(int browseNum) {
		this.browseNum = browseNum;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public int getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
