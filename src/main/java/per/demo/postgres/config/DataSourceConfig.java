package per.demo.postgres.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import per.demo.postgres.config.properties.DataSourceProperties;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * DataSourceConfig
 *
 * @author Wilson
 * @date 18-4-12
 */
@Configuration
@Import(DataSourceProperties.class)
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(DataSourceProperties properties) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setFilters(properties.getFilters());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMaxWait(properties.getMaxWait());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setTestWhileIdle(properties.getTestWhileIdle());
        dataSource.setTestOnReturn(properties.getTestOnReturn());
        dataSource.setPoolPreparedStatements(properties.getPoolPreparedStatements());
        dataSource.setMaxOpenPreparedStatements(properties.getMaxOpenPreparedStatements());
        dataSource.setAsyncInit(properties.getAsyncInit());
        return dataSource;
    }

}
