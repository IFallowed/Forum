/**
 * @Title:Forum/com.forum.action/UserAction.java
 * @Description:
 */
package com.forum.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.forum.entity.User;
import com.forum.exception.ForumException;
import com.forum.service.ThemePostService;
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
	private ThemePostService themePostService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setThemePostService(ThemePostService themePostService) {
		this.themePostService = themePostService;
	}

	/**
	 * 
	 * @Description: 处理注册请求
	 * @Return Type:String
	 * @param request
	 * @param response
	 * @return
	 */
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
	
	/**
	 * 
	 * @Description: 处理登录请求
	 * @Return Type:String
	 * @param request
	 * @param response
	 * @return
	 */
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
			request.getSession().setAttribute("user", newUser);
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
	
	/**
	 * 
	 * @Description: 获取登录的用户信息
	 * @Return Type:String
	 * @param request
	 * @param response
	 * @return
	 */
	public String getUser(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		Map<String, String> result = new HashMap<String, String>();
		
		if(null != userId && !"".equals(userId)) {
			try {
				User user = userService.getUserById(Integer.parseInt(userId));
				result.put("code", "200");
				result.put("msg", "ok");
				result.put("id",String.valueOf(user.getId()));
				result.put("nickName",user.getNickName());
				result.put("sex", String.valueOf(user.getSex()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
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

	/**
	 * 
	 * @Description: 处理更新用户信息的请求
	 * @Return Type:String
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateUser(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String nickName = request.getParameter("nickName");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String signature = request.getParameter("signature");
		Map<String, String> result = new HashMap<String, String>();
		if(null != userId && !"".equals(userId)) {
			User user = new User();
			user.setId(Integer.valueOf(userId));
			user.setNickName(nickName);
			user.setPhone(phone);
			user.setCity(city);
			user.setSignature(signature);
			user.setSex(Integer.valueOf(sex));
			System.out.println(user.getSignature());
				userService.updateUser(user);
				result.put("code", "200");
				result.put("msg", "ok");
				try {
					user = userService.getUserById(user.getId());
					request.getSession().setAttribute("user", user);
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
	
	/**
	 * 
	 * @Description: 处理修改密码的请求
	 * @Return Type:String
	 * @param request
	 * @param response
	 * @return
	 */
	public String updatePwd(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String Opwd = request.getParameter("Opwd");
		String Npwd = request.getParameter("Npwd");
		Map<String, String> result = new HashMap<String, String>();
		User saveUser = null;
		try {
			saveUser = userService.getUserById(Integer.parseInt(userId));
			if(Opwd.equals(saveUser.getPassword())) {
				User user = new User();
				user.setId(Integer.parseInt(userId));
				user.setPassword(Npwd);
				userService.updateUser(user);
				result.put("code", "200");
				result.put("msg", "ok");
			}
			else {
				result.put("code", "203");
				result.put("msg", "原密码不正确");
			}
		} catch (NumberFormatException e) {
			LogUtil.error(e.getMessage());
		} catch (ForumException e) {
			LogUtil.error(e.getMessage());
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

	public String upAvatar(HttpServletRequest request,HttpServletResponse response) {
		Map<String, String> result = new HashMap<String, String>();
		 // 获得磁盘文件条目工厂 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String contextPath = request.getContextPath();
		factory.setRepository(new File(contextPath + "/tmp_avatar"));  
        // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024 * 1024); 
        
        // 高水平的API文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        try {
        	// 提交上来的信息都在这个list里面 
			List<FileItem> itemList = upload.parseRequest(request);
			Iterator<FileItem> itemIt = itemList.iterator();
			while (itemIt.hasNext()) {
				FileItem fileItem = (FileItem) itemIt.next();
				fileItem.getString("UTF-8");
				//忽略其他不是文件域的所有表单信息
				if(!fileItem.isFormField()) {
					String fileName = fileItem.getName(); //获取上传的文件名
					long fileSize = fileItem.getSize();//获取上传的文件大小(字节为单位)
					if ((fileName == null || fileName.equals("")) && fileSize == 0) {
	                    continue;//跳到while检查条件
	                }
	                int end = fileName.length();
	                int begin = fileName.lastIndexOf("\\");
	                String newName = fileName.substring(begin + 1, end);
	                if (newName.length() == 0) {
	                	LogUtil.error("上传文件导入异常，请重新上传...");
	                	result.put("code", "206");
	    				result.put("msg", "上传文件导入异常，请重新上传");
	                }
	                else {
	                	//保存文件
	                	//用原文件名，作为上传文件的文件名。“/code”为目标路径
	                	String genePicPath=request.getSession().getServletContext().getRealPath("/userAvatar");
	                	System.out.println("path--->" +  genePicPath);
	                	System.out.println("fileName--->" + fileName);
	                	File saveFile = new File(genePicPath,fileName);
	                	if(!saveFile.exists()){
	                		fileItem.write(saveFile);
	                		fileItem.delete();
	                	}
	                	User user = (User) request.getSession().getAttribute("user");
	                	System.out.println(user.getId());
	                	user.setAvatar(fileName);
	                	userService.updateUser(user);
	                	System.out.println("上传结束");
	                	result.put("code", "200");
	    				result.put("msg", "ok");
	    				result.put("img",fileName);
	                }
				}
				
			}
        } catch (FileUploadException e) {
			LogUtil.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e.getMessage());
		} catch (Exception e) {
			LogUtil.error(e.getMessage());
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
