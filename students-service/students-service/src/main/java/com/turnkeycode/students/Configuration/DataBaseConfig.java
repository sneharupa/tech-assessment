package com.turnkeycode.students.Configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:sqlserver://localhost:1433;databaseName=localmssqldb")
                .username("root_user")
                .password("root_password")
                .build();
    }
}
