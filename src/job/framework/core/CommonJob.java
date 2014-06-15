package job.framework.core;

import java.util.Map;

import job.framework.lang.JobException;


/**
 * ��ҵʵ���ӿڣ�������ҵ��ʵ��CommonJob����
 * 
 * 
 * @author zhouwei
 */
public interface CommonJob {
 
	/**
	 * <P>��ҵ�������</P>
	 * 
	 * @param jobId
	 * @param dsPos ����Դ��Ϊ���ҵ���ҵ���ڵ����ݿ���ã���������������
	 * @param jobConfig
	 * @throws JobException
	 * @author zhouwei 
	 */
	public int execute(long jobId, int dsPos, Map<String,String> jobConfig) throws JobException;

}
