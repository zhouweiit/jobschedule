package com.job.common.test.biz;

import java.util.List;

import javax.annotation.Resource;

import org.commonjobframework.lang.JobException;
import org.springframework.stereotype.Component;

import com.job.common.test.dao.UserDao;
import com.job.common.test.entity.User;

@Component("testUserService")
public class UserService {
	
	@Resource(name="testUserDao")
	private UserDao userDao;
	
	public User getUserById(int id) throws JobException{
		return userDao.getUserById(id);
	}

	public List<User> getAllUser(int dos) throws JobException{
		return userDao.getAllUser(dos);
	}

	public void updateUser(User user) throws JobException{
		userDao.updateUser(user);
	}
	
	public void insertUser(User user) throws JobException{
		userDao.insertUser(user);
	}
}
