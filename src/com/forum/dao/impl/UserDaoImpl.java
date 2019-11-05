/**
 * @Title:Forum/com.forum.dao.impl/UserDaoImpl.java
 * @Description:
 */
package com.forum.dao.impl;

import java.sql.SQLException;

import com.forum.dao.UserDao;
import com.forum.dao.mapper.UserRowMapper;
import com.forum.entity.User;
import com.jdbc.util.DBTemplate;

/**
 * @author kc
 * @Description: 用户数据操作实现
 * @Date: 2019年11月4日上午9:55:56
 * @version: 1.0
 */
public class UserDaoImpl implements UserDao {

	/**
	 * @see com.forum.dao.UserDao#addOne(com.forum.entity.User)
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int addOne(User user) throws SQLException {
		String sql = "insert t_user (u_mail,u_password,u_sex,u_gold,u_createTime) values (?,?,?,100,now())";
		int row = DBTemplate.insert(sql, user.getMail(),user.getPassword(),user.getSex());
		return row;
	}

	/**
	 * @see com.forum.dao.UserDao#getByMail(java.lang.String)
	 * @param mail
	 * @return
	 * @throws SQLException
	 */
	@Override
	public User getByMail(String mail) throws SQLException {
		String sql = "select u_id,u_mail,u_password,u_nickName,u_sex,u_phone,u_gold,u_city,u_signature,u_avatar,u_createTime from t_user where u_mail = ?";
		User user = DBTemplate.selectOne(sql, new UserRowMapper(), mail);
		return user;
	}

	/**
	 * @see com.forum.dao.UserDao#getById(int)
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public User getById(int id) throws SQLException {
		String sql = "select u_id,u_mail,u_password,u_nickName,u_sex,u_phone,u_gold,u_city,u_signature,u_avatar,u_createTime from t_user where u_id = ?";
		User user = DBTemplate.selectOne(sql, new UserRowMapper(), id);
		return user;
	}

}
