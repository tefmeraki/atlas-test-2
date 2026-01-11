package com.atlas.club.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DbPingService {

    private final JdbcTemplate jdbcTemplate;

    public DbPingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> ping() {
        Integer one = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return Map.of(
                "db", "OK",
                "value", one
        );
    }
}
