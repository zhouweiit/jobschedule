package job.framework.ds;

/**
 * 在运行时态动态设置该线程的database的key
 * 
 * @author zhouwei
 */
public class DataSourceSetter {

	/**
	 * 当前线程的datasourceKey
	 */
	@SuppressWarnings("unchecked")
	private static final ThreadLocal contextHolder = new ThreadLocal();

	/**
	 * 设置database的key
	 * 
	 * @param dataSourceKey
	 * @author zhouwei
	 */
	@SuppressWarnings("unchecked")
	public static void setDatabase(String dataSourceKey) {
		contextHolder.set(dataSourceKey);
	}

	/**
	 * 获取datasource的key
	 * 
	 * @return 
	 */
	public static String getDatabase() {
		return (String) contextHolder.get();
	}
}
