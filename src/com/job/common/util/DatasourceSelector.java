package com.job.common.util;
/*
 * ����Դѡ����
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
