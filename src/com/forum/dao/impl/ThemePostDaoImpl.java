/**
 * @Title:Forum/com.forum.dao.impl/ThemePostDaoImpl.java
 * @Description:
 */
package com.forum.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.forum.dao.ThemePostDao;
import com.forum.dao.mapper.AllThemePostRowMapper;
import com.forum.dao.mapper.ThemePostRowMapper;
import com.forum.entity.ThemePost;
import com.forum.util.StringUtil;
import com.jdbc.util.DBTemplate;
import com.jdbc.util.RowMapper;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日上午11:54:36
 * @version: 1.0
 */
public class ThemePostDaoImpl implements ThemePostDao {

	/**
	 * @see com.forum.dao.ThemePostDao#add(com.forum.entity.ThemePost)
	 * @param tp
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int add(ThemePost tp) throws SQLException {
		String sql = "insert into t_themepost (tp_title,tp_content,tp_userId,tp_type,tp_state,tp_gold,tp_browseNum,tp_replyNum,tp_collectNum,tp_createTime) values (?,?,?,?,?,?,?,?,?,now())";
		int row = DBTemplate.insert(sql, tp.getTitle(),tp.getContent(),tp.getUser().getId(),tp.getType(),tp.getState(),tp.getGold(),tp.getBrowseNum(),tp.getReplyNum(),tp.getCollectNum());
		return row;
	}

	/**
	 * @see com.forum.dao.ThemePostDao#queryAllPostByPage(java.lang.String, java.lang.String, int, int)
	 * @param nickName
	 * @param title
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public List<ThemePost> queryAllPostByPage(String nickName, String title,String type,String state, int pageNo, int pageSize) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select tp.tp_id,tp.tp_title,tp.tp_content,tp.tp_userId,tp.tp_type,tp.tp_state,tp.tp_gold,tp.tp_browseNum,tp.tp_replyNum,tp.tp_collectNum,tp.tp_createTime,u.u_nickName,u.u_avatar ");
		sql.append(" from t_themepost tp inner join t_user u on tp.tp_userId = u.u_id where 1=1 ");
		if(!StringUtil.isEmpty(nickName)) {
			sql.append(" and  u.u_nickname = '")
			  .append(nickName)
			  .append("'");
		}
		if(!StringUtil.isEmpty(type)) {
			sql.append(" and  tp.tp_type = '")
			  .append(type)
			  .append("'");
		}
		if(!StringUtil.isEmpty(state)) {
			sql.append(" and  tp.tp_state = '")
			  .append(state)
			  .append("'");
		}
		if(!StringUtil.isEmpty(title)){
			sql.append(" and  tp.tp_title like '%")
			  .append(title)
			  .append("%'");
		}
		sql.append("  order by tp.tp_createTime desc limit ?,?");
		return DBTemplate.selectList(sql.toString(), new AllThemePostRowMapper(), (pageNo -1) *pageSize, pageSize);
	}

	/**
	 * @see com.forum.dao.ThemePostDao#queryAllPostCnt(java.lang.String, java.lang.String)
	 * @param nickName
	 * @param title
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int queryAllPostCnt(String nickName, String title,String type,String state) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(0) as cnt from t_themepost tp inner join t_user u on tp.tp_userId = u.u_id where 1=1 ");
		if(!StringUtil.isEmpty(nickName)) {
			sql.append(" and  u.u_nickname = '")
			  .append(nickName)
			  .append("'");
		}
		if(!StringUtil.isEmpty(type)) {
			sql.append(" and  tp.tp_type = '")
			  .append(type)
			  .append("'");
		}
		if(!StringUtil.isEmpty(state)) {
			sql.append(" and  tp.tp_state = '")
			  .append(state)
			  .append("'");
		}
		if(!StringUtil.isEmpty(title)){
			sql.append(" and  tp.tp_title like '%")
			  .append(title)
			  .append("%'");
		}
		return DBTemplate.selectOne(sql.toString(), new RowMapper<Integer>() {

			@Override
			public Integer mapperObject(ResultSet arg0) throws SQLException {
				return arg0.getInt("cnt");
			}
		});
	}

	/**
	 * @see com.forum.dao.ThemePostDao#getPostById(int)
	 * @param postId
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public ThemePost getPostById(int postId) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select tp.tp_id,tp.tp_title,tp.tp_content,tp.tp_userId,tp.tp_type,tp.tp_state,tp.tp_gold,tp.tp_browseNum,tp.tp_replyNum,tp.tp_collectNum,tp.tp_createTime,u.u_nickName,u.u_avatar ");
		sql.append(" from t_themepost tp inner join t_user u on tp.tp_userId = u.u_id where tp.tp_id = ? ");
		return DBTemplate.selectOne(sql.toString(), new AllThemePostRowMapper(), postId);
	}

}
