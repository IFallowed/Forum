/**
 * @Title:Forum/com.forum.service/ThemePostService.java
 * @Description:
 */
package com.forum.service;

import com.forum.entity.ThemePost;
import com.forum.util.PageModel;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日上午11:55:09
 * @version: 1.0
 */
public interface ThemePostService {

	/**
	 * @Description: 
	 * @Return Type:void
	 * @param tp 
	 */
	void add(ThemePost tp);
	
	/**
	 * @Description: 
	 * @Return Type:void
	 * @param userId 
	 */
	void getPostsByUserId(int userId);

	/**
	 * @Description: 
	 * @Return Type:PageModel<ThemePost>
	 * @param nickName
	 * @param title
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 */
	PageModel<ThemePost> queryAllPostByPage(String nickName, String title, String type, String state, int pageNo, int pageSize);

	/**
	 * @Description: 
	 * @Return Type:ThemePost
	 * @param postId
	 * @return 
	 */
	ThemePost getThemePostById(int postId);

}
