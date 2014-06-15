package job.framework.ds;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ���ݿ�·���࣬��̳�org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
 * 
 * ͨ��determineCurrentLookupKey����ʵʱ��ȡSpring�����õ����ݿ�key
 * 
 * ͨ��key��Spring����ʵʱ��ȡ���ݿ�ʵ��
 * 
 * @author zhouw
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
    
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSetter.getDatabase();
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
