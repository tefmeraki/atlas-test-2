
package com.atlas.club.repository;

import com.atlas.club.model.Actividad;
import com.atlas.club.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    long countByActividadAndEstado(Actividad actividad, String estado);
}
