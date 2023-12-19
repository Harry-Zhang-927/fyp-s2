package com.example.S2.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/BE2?useSSL=false&serverTimezone=UTC")
                .username("root")
                .password("20010927")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
