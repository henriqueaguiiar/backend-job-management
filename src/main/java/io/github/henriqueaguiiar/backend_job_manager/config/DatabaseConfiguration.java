package io.github.henriqueaguiiar.backend_job_manager.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {


    @Bean
    public DataSource hikariDataSource(){
        return null;
    }

}
