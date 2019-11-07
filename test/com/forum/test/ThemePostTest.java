/**
 * @Title:Forum/com.forum.test/ThemePostTest.java
 * @Description:
 */
package com.forum.test;

import org.junit.Test;

import com.forum.entity.ThemePost;
import com.forum.entity.User;
import com.forum.service.ThemePostService;
import com.jdbc.util.ObjectFactory;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日下午1:57:16
 * @version: 1.0
 */
public class ThemePostTest {
	
	public ThemePostService themePostService = (ThemePostService) ObjectFactory.createObject("themePostService");
	@Test
	public void testAdd() {
		for (int i = 0; i < 5; i++) {
			ThemePost tp = new ThemePost();
			tp.setTitle("主题" + i);
			tp.setContent("内容" + i);
			User user = new User();
			user.setId(1);
			tp.setUser(user);
			tp.setType("html");
			tp.setState("未结");
			tp.setGold(100);
			tp.setBrowseNum(5);
			tp.setReplyNum(0);
			tp.setCollectNum(2);
			themePostService.add(tp);
		}
		for (int i = 5; i < 10; i++) {
			ThemePost tp = new ThemePost();
			tp.setTitle("主题" + i);
			tp.setContent("内容" + i);
			User user = new User();
			user.setId(1);
			tp.setUser(user);
			tp.setType("css");
			tp.setState("未结");
			tp.setGold(100);
			tp.setBrowseNum(5);
			tp.setReplyNum(0);
			tp.setCollectNum(2);
			themePostService.add(tp);
		}
		for (int i = 10; i < 15; i++) {
			ThemePost tp = new ThemePost();
			tp.setTitle("主题" + i);
			tp.setContent("内容" + i);
			User user = new User();
			user.setId(1);
			tp.setUser(user);
			tp.setType("javascript");
			tp.setState("未结");
			tp.setGold(100);
			tp.setBrowseNum(5);
			tp.setReplyNum(0);
			tp.setCollectNum(2);
			themePostService.add(tp);
		}
		for (int i = 15; i < 20; i++) {
			ThemePost tp = new ThemePost();
			tp.setTitle("主题" + i);
			tp.setContent("内容" + i);
			User user = new User();
			user.setId(1);
			tp.setUser(user);
			tp.setType("jquery");
			tp.setState("未结");
			tp.setGold(100);
			tp.setBrowseNum(5);
			tp.setReplyNum(0);
			tp.setCollectNum(2);
			themePostService.add(tp);
		}
	}
	
	@Test
	public void testaaa() throws Exception {
		System.out.println("aaaaa");
	}
}
