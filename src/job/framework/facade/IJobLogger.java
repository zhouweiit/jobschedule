package job.framework.facade;

public interface IJobLogger {

	public void startLog();
	
	public void abnormalLog();
	
	public void processLog(int processItems);
	
	public void errorLog(String errKey, Exception e);
	
	public void endLog();
	
	public void errorLog(String errKey);

}
