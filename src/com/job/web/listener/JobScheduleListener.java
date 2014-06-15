package com.job.web.listener;

import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import job.framework.ched.QuartzJobScheduler;
import job.framework.sched.model.ScheduleJob;

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
			//加载任务至调度器，需根据自己应用实际情况编写
			//可以从配置文件或者数据库中加载需要调用的作业
			
			//一个加载至调度器的demo
			ScheduleJob demoJob = new ScheduleJob();
			demoJob.setDsPos(0);
			demoJob.setJobAttr("1_demoJob");
			demoJob.setFetchLimit(1000);
			demoJob.setJobScriptName("DemoJob");
			demoJob.setIsThreadSupported(0);
			demoJob.setJobConfig(new HashMap<String,String>());
			demoJob.setJobCronExp("*/10 * * * * ?");
			demoJob.setJobGroup("1_demoJob");
			demoJob.setJobId(1);
			demoJob.setJobType(ScheduleJob.JAVA);
			QuartzJobScheduler.schedule(demoJob);
		} catch (Exception e) {
			logger.error("Job Cluster Service started with error:" + e.toString(), JobLogger.CLUSTER);
		}
	}
	
}
