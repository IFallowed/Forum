/**
 * @Title:Forum/com.forum.action/UserAction.java
 * @Description:
 */
package com.forum.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.entity.User;
import com.forum.exception.ForumException;
import com.forum.service.UserService;
import com.forum.util.DateUtil;
import com.jdbc.util.LogUtil;
import com.jdbc.util.ObjectFactory;

import net.sf.json.JSONObject;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月2日下午2:29:06
 * @version: 1.0
 */
public class UserAction {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public String regist(HttpServletRequest request,HttpServletResponse response) {
		User user = new User();
		user.setMail(request.getParameter("mail"));
		user.setPassword(request.getParameter("password"));
		user.setNickName(request.getParameter("nickName"));
		user.setSex(Integer.valueOf(request.getParameter("sex")));
		System.out.println("sex----"+user.getSex());
		
		Map<String, String> result = new HashMap<String, String>();
		try {
			userService.regist(user);
//			request.getSession().setAttribute("user", user);
			
			result.put("code", "200");
			result.put("msg", "ok");
			result.put("mail",user.getMail());
		} catch (ForumException e) {
			LogUtil.info(e.getMessage());
			result.put("code", "201");
			result.put("msg", e.getMessage());
			result.put("mail",user.getMail());
			result.put("password",user.getPassword());
			result.put("sex",String.valueOf(user.getSex()));
			result.put("nickName", user.getNickName());
		}
		
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
	
	public String login(HttpServletRequest request,HttpServletResponse response) {
		User user = new User();
		user.setMail(request.getParameter("mail"));
		user.setPassword(request.getParameter("password"));
		Map<String, String> result = new HashMap<String, String>();
		try {
			User newUser = userService.login(user);
			result.put("code", "200");
			result.put("msg", "ok");
			result.put("id",String.valueOf(newUser.getId()));
		} catch (ForumException e) {
			result.put("code", e.getCode());
			result.put("msg", e.getMsg());
			result.put("mail", user.getMail());
		}
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
	
	public String getUser(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		System.out.println("userID----" + userId);
		Map<String, String> result = new HashMap<String, String>();
		if(null != userId) {
			try {
				User user = userService.getUserById(Integer.valueOf(userId));
				result.put("code", "200");
				result.put("msg", "ok");
				result.put("id",String.valueOf(user.getId()));
				result.put("mail",user.getMail());
				result.put("password",user.getPassword());
				result.put("nickName",user.getNickName());
				result.put("sex", String.valueOf(user.getSex()));
				result.put("phone", user.getPhone());
				result.put("gold", String.valueOf(user.getGold()));
				result.put("city", user.getCity());
				result.put("signature", user.getSignature());
				result.put("createTime", DateUtil.parseDateToStr(user.getCreateTime(), "yyyy-MM-dd"));
			} catch (NumberFormatException e) {
				LogUtil.error(e.getMessage());
			} catch (ForumException e) {
				result.put("code", e.getCode());
				result.put("msg", e.getMsg());
			}
		}
		else {
			result.put("code", "202");
			result.put("msg", "用户不存在");
		}
		
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
}
