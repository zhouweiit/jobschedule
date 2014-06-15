package job.framework.persist.ibatis;

import java.sql.SQLException;
import java.util.List;

import job.framework.persist.PersistManager;


import com.ibatis.sqlmap.client.SqlMapClient;

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
