/**
 * @Title:Forum/com.forum.exception/ForumException.java
 * @Description:
 */
package com.forum.exception;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月2日下午3:01:12
 * @version: 1.0
 */
public class ForumException extends Exception {
	
	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 
	 */
	public ForumException(String msg) {
		super(msg);
	}
	
	public ForumException(String code,String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
}
