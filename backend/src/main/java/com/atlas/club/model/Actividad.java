
package com.atlas.club.model;

import jakarta.persistence.*;

@Entity
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int plazasTotales;
    private boolean activa = true;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public int getPlazasTotales() { return plazasTotales; }
    public boolean isActiva() { return activa; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPlazasTotales(int plazasTotales) { this.plazasTotales = plazasTotales; }
    public void setActiva(boolean activa) { this.activa = activa; }
}
