package org.commonjobframework.persist;

import java.sql.SQLException;
import java.util.List;

public interface PersistManager {
	public Object queryObject(String id, Object parameterObject)
			throws SQLException;

	public Object queryObject(String id) throws SQLException;

	public List<Object> queryObjects(String id, Object parameterObject)
			throws SQLException;

	public List<Object> queryObjects(String id) throws SQLException;

	public Object insertObject(String id, Object parameterObject)
			throws SQLException;

	public Object insertObject(String id) throws SQLException;

	public int updateObject(String id, Object parameterObject)
			throws SQLException;

	public int updateObject(String id) throws SQLException;

	public int deleteObject(String id) throws SQLException;

	public int deleteObject(String id, Object parameterObject)
			throws SQLException;
}
