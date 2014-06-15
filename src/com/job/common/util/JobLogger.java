package com.job.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import job.framework.facade.IJobLogger;


/*
 * ��ҵ��־������
 * 
 * @author zhouwei
 */
public class JobLogger implements IJobLogger{

	public static final int RUNTIME = 1;
	
	public static final int ERROR = 2;
	
	public static final int CLUSTER = 3;
	
	//��־��Ŀ¼
	private static String logBaseDir = null;
	
	//��־Ŀ¼
	private String logDir = null;
	
	//��־·��
	private String logPath = null;
	
	static{
		logBaseDir = JobConfigParser.getProperty("job_log_dir");
		File dir = new File(logBaseDir);
		if(!dir.exists()){
			dir.mkdirs();
		}
	}
	
	//��־����(��������չ��.log)
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
				writer.append("[��ҵ��Ⱥʱ��]:" + getLogTime() + "\n");
				writer.append("[��ҵ��Ⱥ��Ϣ]:" + logMessage + "\n");
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
		startLog += "��ҵ����:" + jobAttr + "\n";
		startLog += "��ʼʱ��:" + getLogTime();
		debug(startLog, RUNTIME);
	}
	
	public void endLog(){
		debug("����ʱ��:" + getLogTime(), RUNTIME);
	}
	
	public void processLog(int processItems){
		debug("��������:" + processItems, RUNTIME);
	}
	
	public void abnormalLog(){
		debug("��ֹ��ҵ:�ϴ�δ��������,���ν�ֹ����", RUNTIME);
	}
	
	public void errorLog(String errKey, Exception e){
		String errLog = "--------------------------------------------------\n" + "--------------------------------------------------\n";
		errLog += "��ҵ����:" + jobAttr + "\n";
		errLog += "��־ʱ��:" + getLogTime() + "\n";
		String errKeyIndex = "";
		if (errKey != null){
			errKeyIndex = errKey;
		}
		errLog += "�����ʶ:" + errKeyIndex + "\n";
		errLog += "������Ϣ:" + e.toString() + "\n";
		String errStack = "";
		for (StackTraceElement ele : e.getStackTrace()){
			errStack += ele.toString() + "\n";
		}
		errLog += "�������:" + "\n" + errStack; 
		error(errLog, ERROR);
	}
	
	public void errorLog(String errKey){
		String errLog = "--------------------------------------------------\n" + "--------------------------------------------------\n";
		errLog += "��ҵ����:" + jobAttr + "\n";
		errLog += "��־ʱ��:" + getLogTime() + "\n";
		String errKeyIndex = "";
		if (errKey != null){
			errKeyIndex = errKey;
		}
		errLog += "�Զ������:" + errKeyIndex + "\n";
		error(errLog, ERROR);
	}
}
