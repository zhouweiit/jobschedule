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

/**
 * 作业反射器，负责作业实例化、设置于执行
 * 
 * @author zhouwei
 *
 */
public class JobReflecter {
	
	/**
	 * 根据作业调度器中的调度信息，反射获取作业实例
	 * 
	 * @param job
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
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
	
	/**
	 * 执行作业
	 * @param job
	 * @param jobInstance
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
	public static Integer executeJob(ScheduleJob job, Object jobInstance) throws JobException{
		try {
			Class<?> jobClass = Class.forName("com.job.entrance." + job.getJobScriptName());
			Method executeMethod = jobClass.getMethod("execute", new Class[] { long.class, int.class, Map.class});
			return (Integer)executeMethod.invoke(jobInstance, new Object[]{job.getJobId(), job.getDsPos(), job.getJobConfig()});
		} catch (Exception e){
			throw new JobException(e);
		}
	}
	
	/**
	 * 设置作业的多线程信息
	 * @param job
	 * @param jobInstance
	 * @param threadCondition
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
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

	/**
	 * 设置作业每次抓取的条数
	 * @param job
	 * @param jobInstance
	 * @return
	 * @throws JobException
	 * @author zhouwei
	 */
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
