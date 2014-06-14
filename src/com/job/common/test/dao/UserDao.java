package com.job.common.test.dao;

import java.util.List;

import org.commonjobframework.lang.JobException;

import com.job.common.test.entity.User;

public interface UserDao {
	
	public User getUserById(int id) throws JobException;

	public List<User> getAllUser(int dos) throws JobException;

	public void updateUser(User user) throws JobException;
	
	public void insertUser(User user) throws JobException;

}
