/**
 * @Title:Forum/com.forum.util/aa.java
 * @Description:
 */
package com.forum.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月4日下午7:59:10
 * @version: 1.0
 */
public class aa {
	
	public static void main(String[] args) {
		String string = "/moodApp7/html/user/user/login.do";
		String action = string.substring(string.lastIndexOf("/") + 1, string.indexOf(".do"));
		System.out.println(action);
	}
}
