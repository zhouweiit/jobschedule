package com.job.common.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("JobServiceHolder")
public class JobServiceHolder {

	@Resource
	public com.job.common.test.biz.UserService testUserService;
}
