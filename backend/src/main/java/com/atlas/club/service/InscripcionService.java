
package com.atlas.club.service;

import com.atlas.club.model.Actividad;
import com.atlas.club.model.Inscripcion;
import com.atlas.club.model.Socio;
import com.atlas.club.repository.ActividadRepository;
import com.atlas.club.repository.InscripcionRepository;
import com.atlas.club.repository.SocioRepository;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final ActividadRepository actividadRepository;
    private final SocioRepository socioRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository,
                              ActividadRepository actividadRepository,
                              SocioRepository socioRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.actividadRepository = actividadRepository;
        this.socioRepository = socioRepository;
    }

    public Inscripcion inscribir(Long socioId, Long actividadId) {
        Socio socio = socioRepository.findById(socioId)
                .orElseThrow(() -> new IllegalArgumentException("Socio no existe"));

        Actividad actividad = actividadRepository.findById(actividadId)
                .orElseThrow(() -> new IllegalArgumentException("Actividad no existe"));

        long plazasOcupadas = inscripcionRepository.countByActividadAndEstado(actividad, "ACTIVA");
        if (plazasOcupadas >= actividad.getPlazasTotales()) {
            throw new IllegalStateException("No hay plazas disponibles");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setSocio(socio);
        inscripcion.setActividad(actividad);
        inscripcion.setEstado("ACTIVA");

        return inscripcionRepository.save(inscripcion);
    }
}
