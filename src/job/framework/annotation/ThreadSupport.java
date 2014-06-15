package job.framework.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * 作业支持多线程注解
 * 若作业需支持多线程，需为类添加次注解
 * 
 * 
 * @author zhouwei
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSupport {
}
