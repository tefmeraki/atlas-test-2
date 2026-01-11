
package com.atlas.club.model;

import jakarta.persistence.*;

@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Socio socio;

    @ManyToOne
    private Actividad actividad;

    private String estado = "ACTIVA";

    public Long getId() { return id; }
    public Socio getSocio() { return socio; }
    public Actividad getActividad() { return actividad; }
    public String getEstado() { return estado; }

    public void setSocio(Socio socio) { this.socio = socio; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }
    public void setEstado(String estado) { this.estado = estado; }
}
