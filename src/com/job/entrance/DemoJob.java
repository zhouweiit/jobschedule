package com.job.entrance;

import java.util.Map;

import javax.annotation.Resource;

import job.framework.core.CommonJob;
import job.framework.lang.JobException;

import com.job.common.test.biz.UserService;
import com.job.common.util.JobService;

public class DemoJob extends JobService implements CommonJob{
	
	@Resource
	private UserService testUserService;

	public int execute(long jobId, int dsPos, Map<String, String> jobConfig) throws JobException {
		System.out.println(testUserService);
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		DemoJob job = new DemoJob();
		System.out.println("处理的条数为:"+job.execute(0, 0, null));
	}
} 
