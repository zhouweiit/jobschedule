package job.framework.sched.model;

import java.util.Map;

/**
 * 
 * ��ҵ����entity��������ҵ���������Ϣ
 * 
 * @author zhouwei
 *
 */
public class ScheduleJob {
	
	/*
	 * java��ҵ����
	 */
	public static final int JAVA = 0;

	/*
	 * php��ҵ����
	 */
	public static final int PHP = 1;
	
	/*
	 * ��ʼ�ź�
	 */
	public static final int START = 1;
	
	/*
	 * �����ź�
	 */
	public static final int EXIT = 0;
	
	/*
	 * ��ҵID
	 */
	private long jobId;
	
	/*
	 * jobId + "_" + jobScriptName
	 */
	private String jobAttr;
	
	/*
	 * ��ҵ·��
	 */
	private String jobRootPath;
	
	/*
	 * ��ҵ����
	 */
	private int jobType;

	/*
	 * ��ҵ�ű�����
	 */
	private String jobScriptName;
	
	/*
	 * ��ҵ������
	 */
	private String jobGroup;
	
	/*
	 * ��ҵ��������
	 */
	private String jobCronExp;
	
	/*
	 * ����Դ����
	 */
	private int dsPos;
	
	/*
	 * �Ƿ�֧�ֶ��߳�
	 */
	private int isThreadSupported;
	
	/*
	 * �߳���
	 */
	private int threadCount;
	
	/*
	 * �̷ָ߳���
	 */
	private String threadSeparator;
	
	/*
	 * ��ҵ����
	 */
	private Map<String, String> jobConfig;
	
	/*
	 * ÿ��ץȡ��������¼
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
