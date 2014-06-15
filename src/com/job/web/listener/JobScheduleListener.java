package com.job.web.listener;

import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import job.framework.ched.QuartzJobScheduler;
import job.framework.sched.model.ScheduleJob;

import com.job.common.util.JobLogger;

/*
 * ��ҵ���ȼ�����
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
			//������������������������Լ�Ӧ��ʵ�������д
			//���Դ������ļ��������ݿ��м�����Ҫ���õ���ҵ
			
			//һ����������������demo
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
