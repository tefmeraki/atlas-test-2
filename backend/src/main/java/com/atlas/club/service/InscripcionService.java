package com.atlas.club.service;

import com.atlas.club.exception.BadRequestException;
import com.atlas.club.exception.NotFoundException;
import com.atlas.club.model.Actividad;
import com.atlas.club.model.Inscripcion;
import com.atlas.club.model.Socio;
import com.atlas.club.repository.ActividadRepository;
import com.atlas.club.repository.InscripcionRepository;
import com.atlas.club.repository.SocioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final SocioRepository socioRepository;
    private final ActividadRepository actividadRepository;

    public InscripcionService(
            InscripcionRepository inscripcionRepository,
            SocioRepository socioRepository,
            ActividadRepository actividadRepository
    ) {
        this.inscripcionRepository = inscripcionRepository;
        this.socioRepository = socioRepository;
        this.actividadRepository = actividadRepository;
    }

    @Transactional
    public Inscripcion inscribir(Long socioId, Long actividadId) {
        if (socioId == null || actividadId == null) {
            throw new BadRequestException("socioId y actividadId son obligatorios.");
        }

        Socio socio = socioRepository.findById(socioId)
                .orElseThrow(() -> new NotFoundException("Socio no encontrado: id=" + socioId));

        Actividad actividad = actividadRepository.findById(actividadId)
                .orElseThrow(() -> new NotFoundException("Actividad no encontrada: id=" + actividadId));

        long actuales = inscripcionRepository.countByActividadIdAndEstado(actividadId, "ACTIVA");
        if (actuales >= actividad.getPlazasMax()) {
            throw new BadRequestException("No hay plazas disponibles para la actividad id=" + actividadId);
        }

        Inscripcion ins = new Inscripcion();
        ins.setSocio(socio);
        ins.setActividad(actividad);
        ins.setEstado("ACTIVA");
        return inscripcionRepository.save(ins);
    }

    public List<Inscripcion> listar() {
        return inscripcionRepository.findAll();
    }
}
