package job.framework.ds;

/**
 * ������ʱ̬��̬���ø��̵߳�database��key
 * 
 * @author zhouwei
 */
public class DataSourceSetter {

	/**
	 * ��ǰ�̵߳�datasourceKey
	 */
	@SuppressWarnings("unchecked")
	private static final ThreadLocal contextHolder = new ThreadLocal();

	/**
	 * ����database��key
	 * 
	 * @param dataSourceKey
	 * @author zhouwei
	 */
	@SuppressWarnings("unchecked")
	public static void setDatabase(String dataSourceKey) {
		contextHolder.set(dataSourceKey);
	}

	/**
	 * ��ȡdatasource��key
	 * 
	 * @return 
	 */
	public static String getDatabase() {
		return (String) contextHolder.get();
	}
}
