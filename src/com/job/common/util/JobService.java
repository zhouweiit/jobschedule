package com.job.common.util;

import org.commonjobframework.facade.IJobLogger;

/*
 * ���е���ҵ�߼��ĳ���,���е���ҵ���̳и���
 * 
 * @author zhouwei
 */
public class JobService {

	protected String threadCondition = null;
	
	protected int fetchLimit;

	protected IJobLogger jobLogger = new JobLogger();
	
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
