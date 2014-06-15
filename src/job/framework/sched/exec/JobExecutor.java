package job.framework.sched.exec;

import java.util.HashMap;
import java.util.Map;

import job.framework.lang.JobException;
import job.framework.sched.model.ScheduleJob;

import org.apache.log4j.Logger;
import job.framework.sched.exec.JobReflecter;

public class JobExecutor {

	private static Logger logger = Logger.getLogger(JobExecutor.class);
	
	public static void exec(ScheduleJob job) throws JobException {
		try {
			Map<String,String> confMap = new HashMap<String, String>();
			String jobConfig = JobReflecter.fetchJobConfig(job);
			if (jobConfig != null && !jobConfig.equals("")){
				String[] jobConf = jobConfig.split(" ");
				if(jobConf != null && jobConf.length > 0){
					for(String conf : jobConf){
						confMap.put(conf.split("=")[0], conf.replace(conf.split("=")[0]+ "=", ""));
					}
				}
			}
			job.setJobConfig(confMap);
			logger.info("commonjob framework start to execute java reflect for job [" + job.getJobScriptName() + ".class]");
			if (job.getIsThreadSupported() == 1){//build multiple thread to execute job
				for (int threadIndex = 0; threadIndex < job.getThreadCount(); threadIndex ++){
					Thread thread = new Thread(new JobThread(job.getThreadSeparator() + "%" + job.getThreadCount() + "=" + threadIndex, job));
					thread.start();
			     }
			} else {
				Object jobInstance = JobReflecter.getJobInstance(job);
				JobReflecter.setFetchLimit(job, jobInstance);
				JobReflecter.setThreadCondition(job, jobInstance, "1=1");
			}
			logger.info("commonjob framework finish to execute java reflect for job [" + job.getJobScriptName() + ".class]");
		} catch (Exception e) {
			logger.error("commonjob framework execute java reflect error:" + e.toString());
			throw new JobException(e);
		}
	}
}

class JobThread extends Thread{
	
	private static Logger logger = Logger.getLogger(JobThread.class);
	
	private String threadCondition;
	
	private ScheduleJob job;
	
	public JobThread(String threadCondition, ScheduleJob job) {
		this.threadCondition = threadCondition;
		this.job = job;
	}

	@Override
	public void run() {
		try {
			Object jobInstance = JobReflecter.getJobInstance(job);
			JobReflecter.setThreadCondition(job, jobInstance, threadCondition);
			JobReflecter.setFetchLimit(job, jobInstance);
		} catch(Exception e){
			logger.error("commonjob framework execute multiple thread job error:" + e.toString());
		}
	}
}