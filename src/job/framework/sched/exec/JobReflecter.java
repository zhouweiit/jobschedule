/* 
 * Copyright 2013-2014 commonframework2.0
 */
package job.framework.sched.exec;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import job.framework.facade.IJobLogger;
import job.framework.lang.JobException;
import job.framework.sched.model.ScheduleJob;


public class JobReflecter {
	
	public static Object getJobInstance(ScheduleJob job) throws JobException{
		try {
			Class<?> jobClass = Class.forName("com.job.entrance." + job.getJobScriptName());
			Object jobInstance = jobClass.newInstance();
			Class<?> jobLoggerClass = Class.forName("com.job.common.util.JobLogger");
			Constructor<?> jobLoggerConstructor = jobLoggerClass.getConstructor(new Class[]{String.class});
			Object jobLoggerInstance = jobLoggerConstructor.newInstance(new Object[]{job.getJobAttr()});
			Method setJobLoggerMethod = jobClass.getMethod("setJobLogger", new Class[]{IJobLogger.class});
			setJobLoggerMethod.invoke(jobInstance, new Object[]{jobLoggerInstance});
			return jobInstance;
		} catch (Exception e){
			throw new JobException(e);
		}
	}
	
	public static Integer executeJob(ScheduleJob job, Object jobInstance) throws JobException{
		try {
			Class<?> jobClass = Class.forName("com.job.entrance." + job.getJobScriptName());
			Method executeMethod = jobClass.getMethod("execute", new Class[] { long.class, int.class, Map.class});
			return (Integer)executeMethod.invoke(jobInstance, new Object[]{job.getJobId(), job.getDsPos(), job.getJobConfig()});
		} catch (Exception e){
			throw new JobException(e);
		}
	}
	
	public static Object setThreadCondition(ScheduleJob job, Object jobInstance, String threadCondition) throws JobException{
		try {
			Class<?> jobClass = Class.forName("com.job.entrance." + job.getJobScriptName());
			Method setThreadConditionMethod = jobClass.getMethod("setThreadCondition", new Class[]{String.class});
		    setThreadConditionMethod.invoke(jobInstance, new Object[]{threadCondition});
		    return jobInstance;
		} catch (Exception e){
			throw new JobException(e);
		}
	}

	public static String fetchJobConfig(ScheduleJob job) throws JobException {
		try {
			Class<?> jobTracerClass = Class.forName("com.job.common.util.JobTracer");
			Object jobTracerInstance = jobTracerClass.newInstance();
			Method fetchJobConfigMethod = jobTracerClass.getMethod("fetchJobConfig", new Class[]{int.class});
			return (String)fetchJobConfigMethod.invoke(jobTracerInstance, new Object[]{Integer.parseInt(job.getJobAttr().split("_")[0])});
		}catch (Exception e) {
			throw new JobException(e);
		}
	}
	
	public static Object setFetchLimit(ScheduleJob job, Object jobInstance) throws JobException{
		try {
			Class<?> jobClass = Class.forName("com.job.entrance." + job.getJobScriptName());
			Method setFetchLimitMethod = jobClass.getMethod("setFetchLimit", new Class[]{int.class});
			setFetchLimitMethod.invoke(jobInstance, new Object[]{job.getFetchLimit()});
		    return jobInstance;
		} catch (Exception e){
			throw new JobException(e);
		}
	}
}
