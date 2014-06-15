package job.framework.facade;

/**
 * ��ҵִ����־���
 * 
 * @author zhouwei
 *
 */
public interface IJobLogger {

	/**
	 * ��ʼ��ҵ��־
	 * 
	 * @author zhouwei
	 */
	public void startLog();
	
	/**
	 * �ϴ���ҵδִ�н�����־
	 * 
	 * @author zhouwei
	 */
	public void abnormalLog();
	
	/**
	 * ������ҵִ�д���ҵ������������־
	 * @param processItems ����ҵ����������
	 * @author zhowei
	 */
	public void processLog(int processItems);
	
	/**
	 * ������־
	 * @param errKey �Զ����쳣��־
	 * @param e  �쳣��Ϣ
	 * @author zhouwei
	 */
	public void errorLog(String errKey, Exception e);
	
	/**
	 * ��ҵ���н�����־
	 * @author zhouwei
	 */
	public void endLog();
	
	/**
	 * ������־
	 * @param errKey �Զ����쳣��־
	 * @author zhouwei
	 */
	public void errorLog(String errKey);

}
