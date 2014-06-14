package org.commonjobframework.ds;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{
    
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSetter.getDatabase();
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
