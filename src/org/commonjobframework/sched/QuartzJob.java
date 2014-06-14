package org.commonjobframework.sched;

import org.commonjobframework.sched.exec.JobInvoker;
import org.commonjobframework.sched.model.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class QuartzJob implements Job {

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		ScheduleJob job = (ScheduleJob) context.getJobDetail().getJobDataMap().get("schedule_job");
		JobInvoker.invoke(job);
	}
}
