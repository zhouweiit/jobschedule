package job.framework.ched;

import job.framework.sched.exec.JobInvoker;
import job.framework.sched.model.ScheduleJob;

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
