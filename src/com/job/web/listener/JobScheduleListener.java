package com.job.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.job.common.util.JobLogger;

/*
 * 作业调度监听器
 * 
 * @author zhouwei
 */
public class JobScheduleListener implements ServletContextListener{

	private static JobLogger logger = new JobLogger();
	
	public void contextDestroyed(ServletContextEvent event) {
		logger.debug("Job Cluster exited due to event[" + event.toString() + "].", JobLogger.CLUSTER);
	}

	public void contextInitialized(ServletContextEvent event) {
		logger.debug("Job Cluster Service started.", JobLogger.CLUSTER);
		try {
			//加载任务至调度器
		} catch (Exception e) {
			logger.error("Job Cluster Service started with error:" + e.toString(), JobLogger.CLUSTER);
		}
	}
	
}
