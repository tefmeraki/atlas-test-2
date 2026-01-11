package com.atlas.club.dto;

public class ActividadCreateRequest {
    private String nombre;
    private Integer plazasMax;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getPlazasMax() { return plazasMax; }
    public void setPlazasMax(Integer plazasMax) { this.plazasMax = plazasMax; }
}
