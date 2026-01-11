package com.atlas.club.service;

import com.atlas.club.exception.BadRequestException;
import com.atlas.club.exception.NotFoundException;
import com.atlas.club.model.Actividad;
import com.atlas.club.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public Actividad crear(String nombre, Integer plazasMax) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new BadRequestException("El nombre de la actividad es obligatorio.");
        }
        if (plazasMax == null || plazasMax < 1) {
            throw new BadRequestException("plazasMax debe ser >= 1.");
        }
        Actividad a = new Actividad();
        a.setNombre(nombre.trim());
        a.setPlazasMax(plazasMax);
        return actividadRepository.save(a);
    }

    public List<Actividad> listar() {
        return actividadRepository.findAll();
    }

    public Actividad obtener(Long id) {
        return actividadRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Actividad no encontrada: id=" + id));
    }
}
