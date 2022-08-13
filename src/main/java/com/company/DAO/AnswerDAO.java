package com.company.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AnswerDAO {
    private final JdbcTemplate jdbcTemplate;

    static {
        System.out.println("AnswerDAO was created");
    }

    @Autowired
    public AnswerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addResult(String task, int answer){
        jdbcTemplate.update("INSERT INTO prim VALUES (?, ?)", task, answer);
    }
}
