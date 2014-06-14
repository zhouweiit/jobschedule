package org.commonjobframework.sched.util;

import org.commonjobframework.cache.JobCache;

public class JobThreadManager {

	public static void interrupt(String jobAttr) {
		JobCache.destroyThreads(jobAttr);
	}
}
