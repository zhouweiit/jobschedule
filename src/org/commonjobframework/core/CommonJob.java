package org.commonjobframework.core;

import java.util.Map;

import org.commonjobframework.lang.JobException;

/*
 * <P>
 * ��ҵ�ӿڣ�������ҵ��ʵ��CommonJob����
 * </P>
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
	 */
	public int execute(long jobId, int dsPos, Map<String,String> jobConfig) throws JobException;

}
