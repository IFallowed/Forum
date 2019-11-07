/**
 * @Title:Forum/com.forum.service.impl/ThemePostServiceImpl.java
 * @Description:
 */
package com.forum.service.impl;

import java.sql.SQLException;

import com.forum.dao.ThemePostDao;
import com.forum.entity.ThemePost;
import com.forum.service.ThemePostService;
import com.forum.util.PageModel;
import com.jdbc.util.LogUtil;
import com.jdbc.util.Transaction;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月6日上午11:55:31
 * @version: 1.0
 */
public class ThemePostServiceImpl implements ThemePostService {

	private Transaction tx;
	private ThemePostDao themePostDao;
	
	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	public void setThemePostDao(ThemePostDao themePostDao) {
		this.themePostDao = themePostDao;
	}

	/**
	 * @see com.forum.service.ThemePostService#add(com.forum.entity.ThemePost)
	 * @param tp
	 */
	@Override
	public void add(ThemePost tp) {
		//开启事务
		tx.beginTX();
		try {
			themePostDao.add(tp);
			tx.commit();
		} catch (SQLException e) {
			//回滚，打印错误日志
			tx.rollBack();
			LogUtil.error(e.getMessage());
		}
	}

	/**
	 * @see com.forum.service.ThemePostService#getPostsByUserId(int)
	 * @param userId
	 */
	@Override
	public void getPostsByUserId(int userId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see com.forum.service.ThemePostService#queryAllPostByPage(java.lang.String, java.lang.String, int, int)
	 * @param nickName
	 * @param title
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageModel<ThemePost> queryAllPostByPage(String nickName, String title, String type, String state, int pageNo, int pageSize) {
			PageModel<ThemePost> pageModel = new PageModel<ThemePost>();
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			try {
				pageModel.setDataList(themePostDao.queryAllPostByPage(nickName,title,type,state,pageNo,pageSize));
				pageModel.setCnt(themePostDao.queryAllPostCnt(nickName,title,type,state));
			} catch (SQLException e) {
				LogUtil.error(e.getMessage());
			}
			
		return pageModel;
	}

	/**
	 * @see com.forum.service.ThemePostService#getThemePostById(int)
	 * @param postId
	 * @return
	 */
	@Override
	public ThemePost getThemePostById(int postId) {
		tx.beginTX();
		ThemePost tp = null;
		try {
			tp = themePostDao.getPostById(postId);
			tx.commit();
		} catch (SQLException e) {
			tx.rollBack();
			LogUtil.error(e.getMessage());
		}
		return tp;
	}


}
