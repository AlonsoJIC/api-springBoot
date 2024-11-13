package com.progra.matriculas.dominio.entidades;

import jakarta.persistence.*;

@Entity(name = "tbl_orden_trabajo_linea")
public class OrdenTrabajoLinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_trabajo_linea")
    private long idOrdenTrabajoLinea;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne
    @JoinColumn(name = "id_tarea")
    private Tarea tarea;

    // Getters y Setters
    public long getIdOrdenTrabajoLinea() {
        return idOrdenTrabajoLinea;
    }

    public void setIdOrdenTrabajoLinea(long idOrdenTrabajoLinea) {
        this.idOrdenTrabajoLinea = idOrdenTrabajoLinea;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
}
