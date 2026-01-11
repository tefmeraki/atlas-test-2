package com.atlas.club.dto;

public class InscripcionCreateRequest {
    private Long socioId;
    private Long actividadId;

    public Long getSocioId() { return socioId; }
    public void setSocioId(Long socioId) { this.socioId = socioId; }

    public Long getActividadId() { return actividadId; }
    public void setActividadId(Long actividadId) { this.actividadId = actividadId; }
}
