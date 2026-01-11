package com.atlas.club.controller;

import com.atlas.club.service.DbPingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/db")
public class DbPingController {

    private final DbPingService dbPingService;

    public DbPingController(DbPingService dbPingService) {
        this.dbPingService = dbPingService;
    }

    @GetMapping("/ping")
    public Map<String, Object> ping() {
        return dbPingService.ping();
    }
}
