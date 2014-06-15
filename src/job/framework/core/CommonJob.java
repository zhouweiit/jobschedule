package job.framework.core;

import java.util.Map;

import job.framework.lang.JobException;


/**
 * 作业实例接口，所有作业需实现CommonJob方法
 * 
 * 
 * @author zhouwei
 */
public interface CommonJob {
 
	/**
	 * <P>作业方法入口</P>
	 * 
	 * @param jobId
	 * @param dsPos 数据源，为了找到作业所在的数据库而用，不具有其他意义
	 * @param jobConfig
	 * @throws JobException
	 * @author zhouwei 
	 */
	public int execute(long jobId, int dsPos, Map<String,String> jobConfig) throws JobException;

}
