package com.job.common.util;

import java.io.InputStream;
import java.util.Properties;

/*
 * ×÷ÒµÅäÖÃ½âÎöÆ÷
 * 
 * @author zhouwei
 */
public class JobConfigParser {

	private static final String DEFAULT_CONFIG_FILE = "JobConfig.properties";
	
	public static String getProperty(String propKey) {
		try {
			Properties props = new Properties();
			InputStream is = JobConfigParser.class.getClassLoader().getResourceAsStream(DEFAULT_CONFIG_FILE);
			props.load(is);
			return props.getProperty(propKey);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
