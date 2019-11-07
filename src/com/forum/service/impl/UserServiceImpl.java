/**
 * @Title:Forum/com.forum.service.impl/UserServiceImpl.java
 * @Description:
 */
package com.forum.service.impl;

import java.sql.SQLException;

import com.forum.dao.UserDao;
import com.forum.entity.User;
import com.forum.exception.ForumException;
import com.forum.service.UserService;
import com.jdbc.util.LogUtil;
import com.jdbc.util.Transaction;

/**
 * @author kc
 * @Description: 
 * @Date: 2019年11月2日下午3:02:10
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {
	
	private Transaction tx;
	private UserDao userDao;

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @see com.forum.service.UserService#regist(com.forum.entity.User)
	 * @param user
	 * @throws ForumException 
	 */
	@Override
	public void regist(User user) throws ForumException {
		//开启事务
		tx.beginTX();
		//检测账号存在性
		User saveUser = null;
		try {
			//根据邮箱查询账号
			saveUser = userDao.getByMail(user.getMail());
		} catch (SQLException e) {
			//回滚，打印错误日志
			tx.rollBack();
			LogUtil.error(e.getMessage());
		}
		if(null != saveUser) {
			throw new ForumException("用户名已存在");
		}
		else {
			try {
				//数据库中没有此邮箱就添加这个用户
				userDao.addOne(user);
				//提交事务
				tx.commit();
			} catch (SQLException e) {
				//回滚，打印错误日志
				tx.rollBack();
				LogUtil.error(e.getMessage());
			}
		}
	}

	/**
	 * @see com.forum.service.UserService#login(com.forum.entity.User)
	 * @param user
	 * @throws ForumException 
	 */
	@Override
	public User login(User user) throws ForumException {
		//开启事务
		tx.beginTX();
		//检测账号存在性
		User saveUser = null;
		try {
			//根据邮箱查询账号
			saveUser = userDao.getByMail(user.getMail());
			//提交事务
			tx.commit();
		} catch (SQLException e) {
			//回滚，打印错误日志
			tx.rollBack();
			LogUtil.error(e.getMessage());
		}
		if(null == saveUser) {
			throw new ForumException("202","用户不存在");
		}
		else {
			if(!saveUser.getPassword().equals(user.getPassword())) {
				throw new ForumException("203","密码不正确");
			}
			else {
				return saveUser;
			}
		}
	}

	/**
	 * @see com.forum.service.UserService#getUserById(java.lang.Integer)
	 * @param id
	 * @return 
	 * @throws ForumException 
	 */
	@Override
	public User getUserById(int id) throws ForumException {
		//开启事务
		tx.beginTX();
		//检测账号存在性
		User saveUser = null;
		try {
			saveUser = userDao.getById(id);
			//提交事务
			tx.commit();
		} catch (SQLException e) {
			//回滚，打印错误日志
			tx.rollBack();
			LogUtil.error(e.getMessage());
		}
		if(null == saveUser) {
			throw new ForumException("202","用户不存在");
		}
		else {
			return saveUser;
		}
	}

	/**
	 * @see com.forum.service.UserService#updateUser(com.forum.entity.User)
	 * @param user
	 */
	@Override
	public void updateUser(User user) {
		//开启事务
		tx.beginTX();
		try {
			userDao.updateById(user);
			tx.commit();
		} catch (SQLException e) {
			//回滚，打印错误日志
			tx.rollBack();
			LogUtil.error(e.getMessage());
		}
	}

}
