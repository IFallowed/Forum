/**
 * @Title:Forum/com.forum.dao/ThemePostDao.java
 * @Description:
 */
package com.forum.dao;

import java.sql.SQLException;
import java.util.List;

import com.forum.entity.ThemePost;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日上午11:38:30
 * @version: 1.0
 */
public interface ThemePostDao {
	
	int add(ThemePost tp) throws SQLException;

	/**
	 * @Description: 
	 * @Return Type:List<ThemePost>
	 * @param nickName
	 * @param title
	 * @param type
	 * @param state
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	List<ThemePost> queryAllPostByPage(String nickName, String title,String type,String state, int pageNo, int pageSize) throws SQLException;

	/**
	 * @Description: 
	 * @Return Type:int
	 * @param nickName
	 * @param title
	 * @return 
	 * @throws SQLException 
	 */
	int queryAllPostCnt(String nickName, String title,String type,String state) throws SQLException;

	/**
	 * @Description: 
	 * @Return Type:ThemePost
	 * @param postId
	 * @return 
	 * @throws SQLException 
	 */
	ThemePost getPostById(int postId) throws SQLException;
}
