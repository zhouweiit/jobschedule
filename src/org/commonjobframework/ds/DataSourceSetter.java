package org.commonjobframework.ds;

/*
 * <P>
 * ������ʱ̬��̬���ø��̵߳�database��key
 * </P>
 * 
 * @author zhouwei
 */
public class DataSourceSetter {

	@SuppressWarnings("unchecked")
	private static final ThreadLocal contextHolder = new ThreadLocal();

	/**
	 * <P>����database��key</P>
	 * 
	 * @param dataSourceKey
	 */
	@SuppressWarnings("unchecked")
	public static void setDatabase(String dataSourceKey) {
		contextHolder.set(dataSourceKey);
	}

	/**
	 * <P>��ȡdatasource��key</P>
	 * 
	 * @return
	 */
	public static String getDatabase() {
		return (String) contextHolder.get();
	}
}
