package job.framework.ched;

import job.framework.sched.exec.JobInvoker;
import job.framework.sched.model.ScheduleJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 代理quartz的job类
 * 
 * @author zhouwei
 *
 */
public class QuartzJob implements Job {

	/**
	 * 作业业务逻辑入口
	 * @param context 作业上下文
	 * @return void
	 * @author zhouwei
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob job = (ScheduleJob) context.getJobDetail().getJobDataMap().get("schedule_job");
		JobInvoker.invoke(job);
	}
}
