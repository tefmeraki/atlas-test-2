package com.atlas.club.controller;

import com.atlas.club.dto.InscripcionCreateRequest;
import com.atlas.club.model.Inscripcion;
import com.atlas.club.service.InscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inscripcion crear(@RequestBody InscripcionCreateRequest req) {
        return inscripcionService.inscribir(req.getSocioId(), req.getActividadId());
    }

    @GetMapping
    public List<Inscripcion> listar() {
        return inscripcionService.listar();
    }
}
