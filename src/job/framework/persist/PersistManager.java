package job.framework.persist;

import java.sql.SQLException;
import java.util.List;

/**
 * ���ݿ���ʽӿڣ����������ݿ���ʵķ���
 * 
 * @author zhouwwei
 *
 */
public interface PersistManager {
	/**
	 * ���α����ݷ��ʷ�����ֻ����һ����¼
	 * @param id  sqlmap
	 * @param parameterObject �ύ����
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object queryObject(String id, Object parameterObject) throws SQLException;

	/**
	 * �����α����ݷ��ʷ�����ֻ����һ����¼
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object queryObject(String id) throws SQLException;

	/**
	 * ���α����ݷ��ʷ������ɷ��ض�����¼
	 * @param id  sqlmap
	 * @param parameterObject �ύ����
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public List<Object> queryObjects(String id, Object parameterObject) throws SQLException;

	/**
	 * �����α����ݷ��ʷ������ɷ��ض�����¼
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public List<Object> queryObjects(String id) throws SQLException;

	/**
	 * ����������һ������
	 * @param id  sqlmap
	 * @param parameterObject �ύ����
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object insertObject(String id, Object parameterObject) throws SQLException;

	/**
	 * ������������һ������
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public Object insertObject(String id) throws SQLException;

	/**
	 * ����������һ������
	 * @param id  sqlmap
	 * @param parameterObject �ύ����
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int updateObject(String id, Object parameterObject) throws SQLException;

	/**
	 * ������������һ������
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int updateObject(String id) throws SQLException;

	/**
	 * ������ɾ��һ������
	 * @param id  sqlmap
	 * @param parameterObject �ύ����
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int deleteObject(String id) throws SQLException;

	/**
	 * ��������ɾ��һ������
	 * @param id  sqlmap
	 * @return Object
	 * @throws SQLException
	 * @author zhouwei
	 */
	public int deleteObject(String id, Object parameterObject) throws SQLException;
}
