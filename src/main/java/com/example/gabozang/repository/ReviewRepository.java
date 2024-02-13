package com.example.gabozang.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {
    private final NamedParameterJdbcTemplate template;
    public ReviewRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
}
