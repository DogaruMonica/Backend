package iss.sirius.Service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.name}")
    private String dbName;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Value("${spring.datasource.host}")
    private String dbHost;
    @Value("${spring.datasource.port}")
    private String dbPort;
    @Value("${spring.datasource.driverClassName}")
    private String dbDriver;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setDriverClassName(dbDriver);
        config.setPassword(dbPassword);
        config.setUsername(dbUsername);
        return new HikariDataSource(config);
    }
}
