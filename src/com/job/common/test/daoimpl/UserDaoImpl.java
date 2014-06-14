package com.job.common.test.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.commonjobframework.ds.DataSourceSetter;
import org.commonjobframework.lang.JobException;
import org.commonjobframework.persist.PersistManager;
import org.springframework.stereotype.Component;

import com.job.common.test.dao.UserDao;
import com.job.common.test.entity.User;
import com.job.common.util.DatasourceSelector;

@Component("testUserDao")
public class UserDaoImpl implements UserDao {
	
	@Resource(name = "testPersistManager")
	private PersistManager persistManager;
	
	public User getUserById(int id) throws JobException {
		try {
			DataSourceSetter.setDatabase(DatasourceSelector.selectTestDatasource(id));
			return (User)persistManager.queryObject("test.User.getUserById",id);
		}catch(Exception e){
			throw new JobException(e.getMessage(),e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser(int dos) throws JobException {
		List<?> list = null;
		try {
			DataSourceSetter.setDatabase(DatasourceSelector.selectTestDatasource(dos));
			list = persistManager.queryObjects("test.User.getAllUser");
		}catch(Exception e){
			throw new JobException(e.getMessage(),e);
		}
		return (List<User>)list;
	}

	public void updateUser(User user) throws JobException{
		try {
			DataSourceSetter.setDatabase(DatasourceSelector.selectTestDatasource(user.getId()));
			persistManager.updateObject("test.User.updateUser",user);
		}catch(Exception e){
			throw new JobException(e.getMessage(),e);
		}
	}
	
	public void insertUser(User user) throws JobException{
		try {
			DataSourceSetter.setDatabase(DatasourceSelector.selectTestDatasource(user.getId()));
			persistManager.insertObject("test.User.insertUser",user);
		}catch(Exception e){
			throw new JobException(e.getMessage(),e);
		}
	}
	
}
