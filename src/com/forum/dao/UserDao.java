/**
 * @Title:Forum/com.forum.dao/UserDao.java
 * @Description:
 */
package com.forum.dao;

import java.sql.SQLException;

import com.forum.entity.User;

/**
 * @author kc
 * @Description: 用户数据操作接口
 * @Date: 2019年11月1日下午3:19:20
 * @version: 1.0
 */
public interface UserDao {

	/**
	 * 
	 * @Description: 添加一条用户记录
	 * @Return Type:int
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	int addOne(User user) throws SQLException;
	
	/**
	 * 
	 * @Description: 根据邮箱查询用户
	 * @Return Type:User
	 * @param mail
	 * @return
	 * @throws SQLException
	 */
	User getByMail(String mail) throws SQLException;

	/**
	 * @Description: 
	 * @Return Type:User
	 * @param id
	 * @return 
	 * @throws SQLException 
	 */
	User getById(int id) throws SQLException;

	/**
	 * @Description: 
	 * @Return Type:void
	 * @param user 
	 * @throws SQLException 
	 */
	void updateById(User user) throws SQLException;

}
