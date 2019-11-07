/**
 * @Title:Forum/com.forum.dao.mapper/ThemePostRowMapper.java
 * @Description:
 */
package com.forum.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.forum.entity.ThemePost;
import com.forum.entity.User;
import com.forum.util.DateUtil;
import com.jdbc.util.RowMapper;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日上午11:42:18
 * @version: 1.0
 */
public class AllThemePostRowMapper implements RowMapper<ThemePost> {

	/**
	 * @see com.jdbc.util.RowMapper#mapperObject(java.sql.ResultSet)
	 * @param arg0
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ThemePost mapperObject(ResultSet rs) throws SQLException {
		ThemePost tp = new ThemePost();
		tp.setId(rs.getInt("tp_id"));
		tp.setTitle(rs.getString("tp_title"));
		tp.setContent(rs.getString("tp_content"));
		tp.setType(rs.getString("tp_type"));
		tp.setState(rs.getString("tp_state"));
		tp.setGold(rs.getInt("tp_gold"));
		tp.setBrowseNum(rs.getInt("tp_browseNum"));
		tp.setReplyNum(rs.getInt("tp_replyNum"));
		tp.setCollectNum(rs.getInt("tp_collectNum"));
		tp.setTimeDelay(DateUtil.timeDelay(rs.getString("tp_createTime"), "yyyy-MM-dd HH:mm:ss"));
		
		User user = new User();
		user.setId(rs.getInt("tp_userId"));
		user.setNickName(rs.getString("u_nickName"));
		user.setAvatar(rs.getString("u_avatar"));
		tp.setUser(user);
		return tp;
	}

}
