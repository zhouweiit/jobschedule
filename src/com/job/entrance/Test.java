package com.job.entrance;

import java.util.Map;

import org.commonjobframework.core.CommonJob;
import org.commonjobframework.lang.JobException;

import com.job.common.util.JobService;

public class Test extends JobService implements CommonJob{

	public int execute(long jobId, int dsPos, Map<String, String> jobConfig) throws JobException {
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		new Test().execute(0, 0, null);
	}
} 
