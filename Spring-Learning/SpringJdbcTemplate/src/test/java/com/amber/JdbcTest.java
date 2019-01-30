package com.amber;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTest {

    @Test
    public void test1() {
        //创建连接池
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        driverManagerDataSource.setUrl("jdbc:mysql:///Spring_JDBC");
        //创建模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        jdbcTemplate.update("insert into account value(null, ?, ?)", "amber", 9999d);

    }
}
