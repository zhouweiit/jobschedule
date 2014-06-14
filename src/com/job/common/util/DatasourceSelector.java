package com.job.common.util;
/*
 * 数据源选择器
 * 
 * @author zhouwei
 * 
 */
public class DatasourceSelector {

	public static final String TEST = "test";
	
	public static String selectTestDatasource(int id){
		return TEST + "0" + (id % 10);
	}
}
