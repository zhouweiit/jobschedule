package job.framework.facade;

import job.framework.lang.JobException;

public interface IJobTracer {

	public long startJob(String jobAttr, int dsPos) throws JobException;
	
	public boolean isStarted(String jobAttr, int dsPos) throws JobException;
	
	public void exitJob(long jobId, int dsPos) throws JobException;
	
	public void extraJob(Object jobLog, int dsPos) throws JobException;
	
	public Object getJob(long jobId, int dsPos) throws JobException;
	
	public void editThreadJob(long jobId, int dsPos) throws JobException;
	
	public void scheduleJob(String jobAttr) throws JobException;
	
	public void unscheduleJob(String jobAttr)throws JobException;
	
	public String fetchJobConfig(int taskId) throws JobException;
	
}
