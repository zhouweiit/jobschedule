package job.framework.persist.ibatis;

import java.sql.SQLException;
import java.util.List;

import job.framework.persist.PersistManager;


import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 数据库访问实现类，通过实现接口并包装sqlMapClient的方法，便于项目统一扩展
 * 
 * @author zhouwei
 *
 */
public class IbatisPersistManager implements PersistManager {

	private SqlMapClient sqlMapClient;
    
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public int deleteObject(String id) throws SQLException {
		return sqlMapClient.delete(id);
	}

	public int deleteObject(String id, Object parameterObject)
			throws SQLException {
		return sqlMapClient.delete(id, parameterObject);
	}

	public Object insertObject(String id, Object parameterObject)
			throws SQLException {
		return sqlMapClient.insert(id, parameterObject);
	}

	public Object insertObject(String id) throws SQLException {
		return sqlMapClient.insert(id);
	}

	public Object queryObject(String id, Object parameterObject)
			throws SQLException {
		return sqlMapClient.queryForObject(id, parameterObject);
	}

	public Object queryObject(String id) throws SQLException {
		return sqlMapClient.queryForObject(id);
	}

	@SuppressWarnings("unchecked")
	public List queryObjects(String id, Object parameterObject)
			throws SQLException {
		return sqlMapClient.queryForList(id, parameterObject);
	}

	@SuppressWarnings("unchecked")
	public List queryObjects(String id) throws SQLException {
		return sqlMapClient.queryForList(id);
	}

	public int updateObject(String id, Object parameterObject)
			throws SQLException {
		return sqlMapClient.update(id, parameterObject);
	}

	public int updateObject(String id) throws SQLException {
		return sqlMapClient.update(id);
	}
}
