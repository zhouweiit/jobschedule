package com.job.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import job.framework.facade.IJobLogger;


/*
 * 作业日志处理器
 * 
 * @author zhouwei
 */
public class JobLogger implements IJobLogger{

	public static final int RUNTIME = 1;
	
	public static final int ERROR = 2;
	
	public static final int CLUSTER = 3;
	
	//日志基目录
	private static String logBaseDir = null;
	
	//日志目录
	private String logDir = null;
	
	//日志路径
	private String logPath = null;
	
	static{
		logBaseDir = JobConfigParser.getProperty("job_log_dir");
		File dir = new File(logBaseDir);
		if(!dir.exists()){
			dir.mkdirs();
		}
	}
	
	//日志名称(不包含扩展名.log)
	private String jobAttr;

	public JobLogger() {
		logDir = logBaseDir;
		String ip = JobConfigParser.getProperty("job_server_ip");
		logPath = logDir + ip + "_jobcluster.log";
	}

	public JobLogger(String jobAttr) {
		this.jobAttr = jobAttr;
		logDir = logBaseDir + jobAttr.substring(jobAttr.indexOf("_") + 1);
		File logDirFile = new File(logDir);
		if (!logDirFile.exists()){
			logDirFile.mkdirs();
		}
	}

	public void note(String logMessage, int type) {
		try {
			OutputStreamWriter writer = null;
			if (type == CLUSTER){
				writer = new OutputStreamWriter(new FileOutputStream(logPath, true), "GBK");
				writer.append("--------------------------------------------------\n" + "--------------------------------------------------\n");
				writer.append("[作业集群时间]:" + getLogTime() + "\n");
				writer.append("[作业集群信息]:" + logMessage + "\n");
				writer.append("--------------------------------------------------\n" + "--------------------------------------------------\n");
			} else {
				String logSuffix = null;
				if (type == RUNTIME){
					logSuffix = "_rt.log";
				} else if (type == ERROR){
					logSuffix = "_err.log";
				}
				writer = new OutputStreamWriter(new FileOutputStream(logDir + "/" + jobAttr + logSuffix , true), "GBK");
				writer.append(logMessage + "\n");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void debug(String logMessage, int type) {
		System.out.println(logMessage);
		note(logMessage, type);
	}
	
	public void error(String logMessage, int type){
		System.err.println(logMessage);
		note(logMessage, type);
	}
	
	private String getLogTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return format.format(new Date());
	}
	
	public void startLog(){
		String startLog = "--------------------------------------------------\n" + "--------------------------------------------------\n";
		startLog += "作业名称:" + jobAttr + "\n";
		startLog += "开始时间:" + getLogTime();
		debug(startLog, RUNTIME);
	}
	
	public void endLog(){
		debug("结束时间:" + getLogTime(), RUNTIME);
	}
	
	public void processLog(int processItems){
		debug("处理条数:" + processItems, RUNTIME);
	}
	
	public void abnormalLog(){
		debug("禁止作业:上次未正常结束,本次禁止运行", RUNTIME);
	}
	
	public void errorLog(String errKey, Exception e){
		String errLog = "--------------------------------------------------\n" + "--------------------------------------------------\n";
		errLog += "作业名称:" + jobAttr + "\n";
		errLog += "日志时间:" + getLogTime() + "\n";
		String errKeyIndex = "";
		if (errKey != null){
			errKeyIndex = errKey;
		}
		errLog += "错误标识:" + errKeyIndex + "\n";
		errLog += "错误信息:" + e.toString() + "\n";
		String errStack = "";
		for (StackTraceElement ele : e.getStackTrace()){
			errStack += ele.toString() + "\n";
		}
		errLog += "错误代码:" + "\n" + errStack; 
		error(errLog, ERROR);
	}
	
	public void errorLog(String errKey){
		String errLog = "--------------------------------------------------\n" + "--------------------------------------------------\n";
		errLog += "作业名称:" + jobAttr + "\n";
		errLog += "日志时间:" + getLogTime() + "\n";
		String errKeyIndex = "";
		if (errKey != null){
			errKeyIndex = errKey;
		}
		errLog += "自定义错误:" + errKeyIndex + "\n";
		error(errLog, ERROR);
	}
}
