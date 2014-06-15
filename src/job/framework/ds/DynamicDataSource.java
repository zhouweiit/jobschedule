package job.framework.ds;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据库路由类，需继承org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
 * 
 * 通过determineCurrentLookupKey方法实时获取Spring中配置的数据库key
 * 
 * 通过key由Spring容器实时拿取数据库实例
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
