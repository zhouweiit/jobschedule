package com.job.common.test.dao;

import java.util.List;

import job.framework.lang.JobException;

import com.job.common.test.entity.User;


/**
 * �û���Ϣ���ݲ���DAO
 * @author zhouwei
 *
 */
public interface UserDao {
	
	/**
	 * �����û�ID��ȡ�û���Ϣ
	 * @param id �û�ID
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
	public User getUserById(int id) throws JobException;

	/**
	 * ��ȡ�����û���Ϣ
	 * @param dos
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
	public List<User> getAllUser(int dos) throws JobException;

	/**
	 * ����һ���û���Ϣ
	 * @param user
	 * @throws JobException
	 * @author zhouwei
	 */
	public void updateUser(User user) throws JobException;
	
	/**
	 * ����һ���û���Ϣ
	 * @param user
	 * @throws JobException
	 * @author zhouwei
	 */
	public void insertUser(User user) throws JobException;

}
