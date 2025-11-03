package io.github.henriqueaguiiar.backend_job_manager.infrastructure.config;


import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

   @Bean
   public DataSource hikariDataSource() {;
        HikariConfig hikariconfig = new HikariConfig();
        hikariconfig.setJdbcUrl(url);
        hikariconfig.setUsername(username);
        hikariconfig.setPassword(password);
        hikariconfig.setDriverClassName(driverClassName);

        hikariconfig.setMaximumPoolSize(10);
        hikariconfig.setMaxLifetime(600000);
        hikariconfig.setConnectionTimeout(30000);
        hikariconfig.setPoolName(" 光 Hikari CP");
        hikariconfig.setConnectionTestQuery("SELECT NOW();");

        return new com.zaxxer.hikari.HikariDataSource(hikariconfig);

    }

}
