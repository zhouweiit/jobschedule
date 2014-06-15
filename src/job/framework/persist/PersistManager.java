package job.framework.persist;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库访问接口，定义了数据库访问的方法
 * 
 * @author zhouwwei
 *
 */
public interface PersistManager {
	/**
	 * 带参表数据访问方法，只返回一条记录
	 * @param id  sqlmap
	 * @param parameterObject 提交参数
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object queryObject(String id, Object parameterObject) throws SQLException;

	/**
	 * 不带参表数据访问方法，只返回一条记录
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object queryObject(String id) throws SQLException;

	/**
	 * 带参表数据访问方法，可返回多条记录
	 * @param id  sqlmap
	 * @param parameterObject 提交参数
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public List<Object> queryObjects(String id, Object parameterObject) throws SQLException;

	/**
	 * 不带参表数据访问方法，可返回多条记录
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public List<Object> queryObjects(String id) throws SQLException;

	/**
	 * 带参数插入一条数据
	 * @param id  sqlmap
	 * @param parameterObject 提交参数
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object insertObject(String id, Object parameterObject) throws SQLException;

	/**
	 * 不带参数插入一条数据
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object insertObject(String id) throws SQLException;

	/**
	 * 带参数更新一条数据
	 * @param id  sqlmap
	 * @param parameterObject 提交参数
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int updateObject(String id, Object parameterObject) throws SQLException;

	/**
	 * 不带参数更新一条数据
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int updateObject(String id) throws SQLException;

	/**
	 * 带参数删除一条数据
	 * @param id  sqlmap
	 * @param parameterObject 提交参数
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int deleteObject(String id) throws SQLException;

	/**
	 * 不带参数删除一条数据
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int deleteObject(String id, Object parameterObject) throws SQLException;
}
