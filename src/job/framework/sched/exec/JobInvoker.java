package job.framework.sched.exec;

import job.framework.sched.model.ScheduleJob;

import org.apache.log4j.Logger;
import job.framework.sched.exec.JobExecutor;

public class JobInvoker {

	private static Logger logger = Logger.getLogger(JobInvoker.class);
	
	public static void invoke(ScheduleJob job) {
		try {
			String cmd = null;
			if (job.getJobType() == ScheduleJob.JAVA) {
				JobExecutor.exec(job);
			}
			if (job.getJobType() == ScheduleJob.PHP) {
				cmd = "php " + job.getJobRootPath() + job.getJobScriptName() + ".php";
				if (job.getJobConfig() != null && !job.getJobConfig().equals("")) {
					cmd += " " + job.getJobConfig();
				}
				logger.info("commonjob framework start to execute php command [" + cmd + "] for job [" + job.getJobRootPath() + job.getJobScriptName() + ".php]");
				Runtime.getRuntime().exec(cmd);
				logger.info("commonjob framework finish to execute php command [" + cmd + "] for job [" + job.getJobRootPath() + job.getJobScriptName() + ".php]");
			}
			
		} catch (Exception e) {
			if(job.getJobType() == ScheduleJob.PHP){
				logger.error("commonjob framework execute job [" + job.getJobRootPath() + job.getJobScriptName() + ".php] error:" + e.toString(), e);
			}
			if(job.getJobType() == ScheduleJob.JAVA){
				logger.error("commonjob framework execute job [" + job.getJobScriptName() + ".class] error:" + e.toString(), e);
			}
		}
	}
}
