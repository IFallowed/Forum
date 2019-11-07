/**
 * @Title:Forum/com.forum.action/ThemePostAction.java
 * @Description:
 */
package com.forum.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.entity.ThemePost;
import com.forum.entity.User;
import com.forum.service.ThemePostService;
import com.forum.service.UserService;
import com.forum.util.PageModel;
import com.jdbc.util.LogUtil;

import net.sf.json.JSONObject;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日上午11:55:47
 * @version: 1.0
 */
public class ThemePostAction {
	
	private UserService userService;
	private ThemePostService themePostService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setThemePostService(ThemePostService themePostService) {
		this.themePostService = themePostService;
	}
	
	public String getThemePosts(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		int pageNo = Integer.valueOf(request.getParameter("pageNo"));
		int pageSize = 6;
		PageModel<ThemePost> pageModel = themePostService.queryAllPostByPage(null,null,null,null,pageNo,pageSize);
		System.out.println(pageModel.getDataList().size());
		request.getSession().setAttribute("pageModel", pageModel);
		
		result.put("dataList", pageModel.getDataList());
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			LogUtil.error(e.getMessage());
		}
		writer.write(JSONObject.fromObject(result).toString());
		writer.flush();
		writer.close();
		return "success";
	}
	
	public String getOneThemePost(HttpServletRequest request,HttpServletResponse response) {
		int postId = Integer.valueOf(request.getParameter("postId"));
		ThemePost tp = themePostService.getThemePostById(postId);
		request.getSession().setAttribute("themePost", tp);
		return "success";
	}
	
	public String addOneThemePost(HttpServletRequest request,HttpServletResponse response) {
		int userId = Integer.valueOf(request.getParameter("userId"));
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		ThemePost tp = new ThemePost();
		User user = new User();
		user.setId(userId);
		tp.setUser(user);
		tp.setTitle(title);
		tp.setType(type);
		tp.setContent(content);
		tp.setState("未结");
		tp.setBrowseNum(0);
		tp.setReplyNum(0);
		tp.setCollectNum(0);
		return "success";
	}
}
