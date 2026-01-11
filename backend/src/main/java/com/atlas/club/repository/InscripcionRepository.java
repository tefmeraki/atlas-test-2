package com.atlas.club.repository;

import com.atlas.club.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    @Query("select count(i) from Inscripcion i where i.actividad.id = :actividadId and i.estado = :estado")
    long countByActividadIdAndEstado(@Param("actividadId") Long actividadId, @Param("estado") String estado);
}
