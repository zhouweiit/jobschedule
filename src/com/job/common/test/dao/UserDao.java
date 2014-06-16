package com.job.common.test.dao;

import java.util.List;

import job.framework.lang.JobException;

import com.job.common.test.entity.User;


/**
 * 用户信息数据操作DAO
 * @author zhouwei
 *
 */
public interface UserDao {
	
	/**
	 * 根据用户ID获取用户信息
	 * @param id 用户ID
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
	public User getUserById(int id) throws JobException;

	/**
	 * 获取所有用户信息
	 * @param dos
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
	public List<User> getAllUser(int dos) throws JobException;

	/**
	 * 更新一条用户信息
	 * @param user
	 * @throws JobException
	 * @author zhouwei
	 */
	public void updateUser(User user) throws JobException;
	
	/**
	 * 插入一条用户信息
	 * @param user
	 * @throws JobException
	 * @author zhouwei
	 */
	public void insertUser(User user) throws JobException;

}
