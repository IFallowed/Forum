/**
 * @Title:Forum/com.forum.test/TimeTest.java
 * @Description:
 */
package com.forum.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.forum.util.DateUtil;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日下午4:39:21
 * @version: 1.0
 */
public class TimeTest {

	@Test
	public void testDelay() throws Exception {
		String str = DateUtil.timeDelay("2019-11-6 16:41:00", "yyyy-MM-dd HH:mm:ss");
		System.out.println(str);
	}
}
