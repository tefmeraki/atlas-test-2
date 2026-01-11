package com.atlas.club.controller;

import com.atlas.club.dto.ActividadCreateRequest;
import com.atlas.club.model.Actividad;
import com.atlas.club.service.ActividadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    private final ActividadService actividadService;

    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad crear(@RequestBody ActividadCreateRequest req) {
        return actividadService.crear(req.getNombre(), req.getPlazasMax());
    }

    @GetMapping
    public List<Actividad> listar() {
        return actividadService.listar();
    }

    @GetMapping("/{id}")
    public Actividad obtener(@PathVariable Long id) {
        return actividadService.obtener(id);
    }
}
