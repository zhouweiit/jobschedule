/* 
 * Copyright 2013-2014 commonframework2.0
 */
package org.commonjobframework.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * <P>
 * 作业支持多线程注解
 * 若作业需支持多线程，需为类添加次注解
 * </P>
 * 
 * @author zhouwei
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSupport {

}
