package job.framework.sched.model;

import java.util.Map;

/**
 * 
 * 作业配置entity，定义作业最基本的信息
 * 
 * @author zhouwei
 *
 */
public class ScheduleJob {
	
	/*
	 * java作业类型
	 */
	public static final int JAVA = 0;

	/*
	 * php作业类型
	 */
	public static final int PHP = 1;
	
	/*
	 * 开始信号
	 */
	public static final int START = 1;
	
	/*
	 * 结束信号
	 */
	public static final int EXIT = 0;
	
	/*
	 * 作业ID
	 */
	private long jobId;
	
	/*
	 * jobId + "_" + jobScriptName
	 */
	private String jobAttr;
	
	/*
	 * 作业路径
	 */
	private String jobRootPath;
	
	/*
	 * 作业类型
	 */
	private int jobType;

	/*
	 * 作业脚本名称
	 */
	private String jobScriptName;
	
	/*
	 * 作业组名称
	 */
	private String jobGroup;
	
	/*
	 * 作业调度周期
	 */
	private String jobCronExp;
	
	/*
	 * 数据源代号
	 */
	private int dsPos;
	
	/*
	 * 是否支持多线程
	 */
	private int isThreadSupported;
	
	/*
	 * 线程数
	 */
	private int threadCount;
	
	/*
	 * 线程分隔符
	 */
	private String threadSeparator;
	
	/*
	 * 作业配置
	 */
	private Map<String, String> jobConfig;
	
	/*
	 * 每次抓取多少条记录
	 */
	private int fetchLimit;
	
	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	
	public String getJobAttr() {
		return jobAttr;
	}
  
	public void setJobAttr(String jobAttr) {
		this.jobAttr = jobAttr;
	}

	public String getJobRootPath() {
		return jobRootPath;
	}

	public void setJobRootPath(String jobRootPath) {
		this.jobRootPath = jobRootPath;
	}

	public int getJobType() {
		return jobType;
	}

	public void setJobType(int jobType) {
		this.jobType = jobType;
	}
	
	public String getJobScriptName() {
		return jobScriptName;
	}

	public void setJobScriptName(String jobScriptName) {
		this.jobScriptName = jobScriptName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobCronExp() {
		return jobCronExp;
	}

	public void setJobCronExp(String jobCronExp) {
		this.jobCronExp = jobCronExp;
	}

	public Map<String, String> getJobConfig() {
		return jobConfig;
	}

	public void setJobConfig(Map<String, String> jobConfig) {
		this.jobConfig = jobConfig;
	}

	public int getDsPos() {
		return dsPos;
	}

	public void setDsPos(int dsPos) {
		this.dsPos = dsPos;
	}

	public int getIsThreadSupported() {
		return isThreadSupported;
	}

	public void setIsThreadSupported(int isThreadSupported) {
		this.isThreadSupported = isThreadSupported;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public String getThreadSeparator() {
		return threadSeparator;
	}

	public void setThreadSeparator(String threadSeparator) {
		this.threadSeparator = threadSeparator;
	}

	public int getFetchLimit() {
		return fetchLimit;
	}

	public void setFetchLimit(int fetchLimit) {
		this.fetchLimit = fetchLimit;
	}
}
