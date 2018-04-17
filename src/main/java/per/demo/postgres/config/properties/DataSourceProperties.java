package per.demo.postgres.config.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * DataSourceProperties
 *
 * @author Wilson
 * @date 18-4-12
 */
@Component
@ConfigurationProperties(value = "jdbc")
@PropertySource("jdbc.properties")
@Getter
@Setter
@ToString
public class DataSourceProperties {
    private String url;
    private String username;
    private String password;
    private String filters;
    private Integer maxActive;
    private Integer initialSize;
    private Long maxWait;
    private Integer minIdle;
    private Long timeBetweenEvictionRunsMillis;
    private Long minEvictableIdleTimeMillis;
    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean poolPreparedStatements;
    private Integer maxOpenPreparedStatements;
    private Boolean asyncInit;
}
