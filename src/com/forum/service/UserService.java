/**
 * @Title:Forum/com.forum.service/UserService.java
 * @Description:
 */
package com.forum.service;

import com.forum.entity.ThemePost;
import com.forum.entity.User;
import com.forum.exception.ForumException;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月1日下午3:20:28
 * @version: 1.0
 */
public interface UserService {

	/**
	 * @Description: 
	 * @Return Type:void
	 * @param user 
	 * @throws ForumException 
	 */
	void regist(User user) throws ForumException;

	/**
	 * @Description: 
	 * @Return Type:User
	 * @param user 
	 * @throws ForumException 
	 */
	User login(User user) throws ForumException;

	/**
	 * @Description: 
	 * @Return Type:void
	 * @param id 
	 * @throws ForumException 
	 */
	User getUserById(int id) throws ForumException;

	/**
	 * @Description: 除id,mail,gold以外的字段更新
	 * @Return Type:void
	 * @param user 
	 */
	void updateUser(User user);



}
