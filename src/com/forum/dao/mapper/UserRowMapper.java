/**
 * @Title:Forum/com.forum.dao.mapper/UserRpwMapper.java
 * @Description:
 */
package com.forum.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.forum.entity.User;
import com.forum.util.DateUtil;
import com.jdbc.util.RowMapper;

/**
 * @author kc
 * @Description: 用户的行映射器
 * @Date: 2019年11月1日下午3:57:17
 * @version: 1.0
 */
public class UserRowMapper implements RowMapper<User>{

	/**
	 * @see com.jdbc.util.RowMapper#mapperObject(java.sql.ResultSet)
	 * @param arg0
	 * @return
	 * @throws SQLException
	 */
	@Override
	public User mapperObject(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("u_id"));
		user.setMail(rs.getString("u_mail"));
		user.setPassword(rs.getString("u_password"));
		user.setNickName(rs.getString("u_nickName"));
		user.setSex(rs.getInt("u_sex"));
		user.setPhone(rs.getString("u_phone"));
		user.setGold(rs.getInt("u_gold"));
		user.setCity(rs.getString("u_city"));
		user.setSignature(rs.getString("u_signature"));
		user.setAvatar(rs.getString("u_avatar"));
		user.setCreateTime(DateUtil.parseStrToDate(rs.getString("u_createTime"), "yyyy-MM-dd HH:mm:ss"));
		return user;
	}

}
