package org.commonjobframework.ds;

/*
 * <P>
 * 在运行时态动态设置该线程的database的key
 * </P>
 * 
 * @author zhouwei
 */
public class DataSourceSetter {

	@SuppressWarnings("unchecked")
	private static final ThreadLocal contextHolder = new ThreadLocal();

	/**
	 * <P>设置database的key</P>
	 * 
	 * @param dataSourceKey
	 */
	@SuppressWarnings("unchecked")
	public static void setDatabase(String dataSourceKey) {
		contextHolder.set(dataSourceKey);
	}

	/**
	 * <P>获取datasource的key</P>
	 * 
	 * @return
	 */
	public static String getDatabase() {
		return (String) contextHolder.get();
	}
}
