package com.mady.dynamicds.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @author mady
 * @date 2018/11/06
 */
@Configuration
public class DataSourceConfig {
    //数据源1
    @Bean(name = "datasource1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }
 
    //数据源2
    @Bean(name = "datasource2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }
 
    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("datasource1", dataSource1());
        dsMap.put("datasource2", dataSource2());
 
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // Here to config mybatis (可以再配置文件中设置 ， 也可采用默认设置)
        sqlSessionFactoryBean.setTypeAliasesPackage("com.mady.dynamicds.mapper");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/*.xml"));
        // Here is very important, if don't config this, will can't switch datasource
        // put all datasource into SqlSessionFactoryBean, then will autoconfig SqlSessionFactory
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }

    /**
     * 配置@Transactional注解事物
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
