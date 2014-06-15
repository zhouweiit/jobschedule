package com.job.common.util;

import job.framework.facade.IJobLogger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 所有的作业逻辑的超类,所有的作业均继承该类
 * 
 * @author zhouwei
 */
public class JobService {

	protected String threadCondition = null;
	
	protected int fetchLimit;

	protected IJobLogger jobLogger = new JobLogger();
	
	protected static JobServiceHolder holder;
	
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		holder = (JobServiceHolder)context.getBean("JobServiceHolder");
	}
	
	public String getThreadCondition() {
		return threadCondition;
	}

	public void setThreadCondition(String threadCondition) {
		this.threadCondition = threadCondition;
	}

	public IJobLogger getJobLogger() {
		return jobLogger;
	}

	public void setJobLogger(IJobLogger jobLogger) {
		this.jobLogger = jobLogger;
	}

	public int getFetchLimit() {
		return fetchLimit;
	}

	public void setFetchLimit(int fetchLimit) {
		this.fetchLimit = fetchLimit;
	}
}
