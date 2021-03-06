package job.framework.ched;

import job.framework.lang.JobException;
import job.framework.sched.model.ScheduleJob;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 作业装载类，负责将作业加载进实例或者卸载
 * 
 * @author zhouw
 */
public class QuartzJobScheduler {
	
	/**
	 * 调度器实例
	 */
	private static Scheduler scheduler = null;
    
	/**
	 * log4j
	 */
	private static Logger logger = Logger.getLogger(QuartzJobScheduler.class);

	static {
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			logger.error("commonjob framework initialize quartz scheduler error:" + e.toString());
		}
	}

	/**
	 * 将作业加载进调度器实例
	 * @param job 作业实例
	 * 
	 * @throws JobException
	 * @author zhouwei
	 */
	public static void schedule(ScheduleJob job) throws JobException {
		try {
			logger.info("commonjob framework start to schedule job [" + job.getJobScriptName() + ".class]");
			JobDetail jobDetail = new JobDetail(job.getJobAttr(), job.getJobGroup(), QuartzJob.class);
			jobDetail.getJobDataMap().put("schedule_job", job);
			CronTrigger trigger = new CronTrigger("trigger", job.getJobAttr());
			trigger.setCronExpression(job.getJobCronExp());
			scheduler.scheduleJob(jobDetail, trigger);
			logger.info("commonjob framework finish to schedule job [" + job.getJobScriptName() + ".class]");
		} catch (Exception e){
			logger.error("commonjob framework schedule job [" + job.getJobScriptName() + "] error:" + e.toString());
			throw new JobException(e);
		}
	}
    
	/**
	 * 将作业从调度器中卸载
	 * @param job 作业实例
	 * @throws JobException
	 * 
	 * @author zhouwei
	 */
	public static void unschedule(ScheduleJob job) throws JobException {
		try {
			if(job.getJobType() == ScheduleJob.PHP){
				logger.info("commonjob framework start to unschedule job [" + job.getJobRootPath() + job.getJobScriptName() + ".php]");
				scheduler.deleteJob(job.getJobAttr(), job.getJobGroup());
				logger.info("commonjob framework finish to unschedule job [" + job.getJobRootPath() + job.getJobScriptName() + ".php]");
			}else if(job.getJobType() == ScheduleJob.JAVA){
				logger.info("commonjob framework start to unschedule job [" + job.getJobScriptName() + ".class]");
				scheduler.deleteJob(job.getJobAttr(), job.getJobGroup());
				logger.info("commonjob framework finish to unschedule job [" + job.getJobScriptName() + ".class]");
			}
		} catch (Exception e) {
			logger.error("commonjob framework unschedule job [" + job.getJobScriptName() + "] error:" + e.toString());
			throw new JobException(e);
		}
	}
}
