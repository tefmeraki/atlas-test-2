package com.atlas.club.controller;

import com.atlas.club.dto.SocioCreateRequest;
import com.atlas.club.model.Socio;
import com.atlas.club.service.SocioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Socio crear(@RequestBody SocioCreateRequest req) {
        return socioService.crear(req.getNombre(), req.getEmail());
    }

    @GetMapping
    public List<Socio> listar() {
        return socioService.listar();
    }

    @GetMapping("/{id}")
    public Socio obtener(@PathVariable Long id) {
        return socioService.obtener(id);
    }
}
