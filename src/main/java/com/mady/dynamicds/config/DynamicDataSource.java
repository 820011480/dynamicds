package com.mady.dynamicds.config;
 
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
 
/**
 * @author mady
 * @date 2018-11-06.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为"+DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
