package job.framework.facade;

/**
 * 作业执行日志借口
 * 
 * @author zhouwei
 *
 */
public interface IJobLogger {

	/**
	 * 开始作业日志
	 * 
	 * @author zhouwei
	 */
	public void startLog();
	
	/**
	 * 上次作业未执行结束日志
	 * 
	 * @author zhouwei
	 */
	public void abnormalLog();
	
	/**
	 * 本次作业执行处理业务数据条数日志
	 * @param processItems 处理业务数据条数
	 * @author zhowei
	 */
	public void processLog(int processItems);
	
	/**
	 * 错误日志
	 * @param errKey 自定义异常日志
	 * @param e  异常信息
	 * @author zhouwei
	 */
	public void errorLog(String errKey, Exception e);
	
	/**
	 * 作业运行结束日志
	 * @author zhouwei
	 */
	public void endLog();
	
	/**
	 * 错误日志
	 * @param errKey 自定义异常日志
	 * @author zhouwei
	 */
	public void errorLog(String errKey);

}
