package per.demo.postgres.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import per.demo.postgres.config.properties.DataSourceProperties;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DataSourceConfig
 *
 * @author Wilson
 * @date 18-4-12
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setFilters(dataSourceProperties.getFilters());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setInitialSize(dataSourceProperties.getInitialSize());
        dataSource.setMaxWait(dataSourceProperties.getMaxWait());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
        dataSource.setTestWhileIdle(dataSourceProperties.getTestWhileIdle());
        dataSource.setTestOnReturn(dataSourceProperties.getTestOnReturn());
        dataSource.setPoolPreparedStatements(dataSourceProperties.getPoolPreparedStatements());
        dataSource.setMaxOpenPreparedStatements(dataSourceProperties.getMaxOpenPreparedStatements());
        dataSource.setAsyncInit(dataSourceProperties.getAsyncInit());
        return dataSource;
    }


    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public  TransactionInterceptor transactionInterceptor(PlatformTransactionManager transactionManager){
        Properties properties = new Properties();
        properties.put("*","PROPAGATION_REQUIRED");
        return new TransactionInterceptor(transactionManager,properties);
    }

}
