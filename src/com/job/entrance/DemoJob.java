package com.job.entrance;

import java.util.Map;

import job.framework.core.CommonJob;
import job.framework.lang.JobException;

import com.job.common.util.JobService;

public class DemoJob extends JobService implements CommonJob{
	
	public int execute(long jobId, int dsPos, Map<String, String> jobConfig) throws JobException {
		System.out.println(holder.testUserService);
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		DemoJob job = new DemoJob();
		System.out.println("处理的条数为:"+job.execute(0, 0, null));
	}
} 
