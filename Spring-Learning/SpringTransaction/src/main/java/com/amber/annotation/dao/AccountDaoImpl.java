package com.amber.annotation.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 基于xml的事务管理
 */
public class AccountDaoImpl implements AccountDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void recive(String name, double money) {
        this.jdbcTemplate.update("update account set money= money + ? where name = ?", money, name);
    }

    public void send(String name, double money) {
        this.jdbcTemplate.update("update account set money = money - ? where name =?", money, name);
    }
}
