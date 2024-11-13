package com.progra.matriculas.dominio.entidades;

import jakarta.persistence.*;

@Entity(name = "tbl_estado_orden")
public class EstadoOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_orden")
    private long idEstadoOrden;

    @Column(name = "nombre")
    private String nombre;

    // Getters y Setters
    public long getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(long idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
