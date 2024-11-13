package com.progra.matriculas.dominio.dto;

import java.time.LocalDateTime;

public record DTOOrdenTrabajo(long idOrden, String descripcion, String estado, LocalDateTime fechaCreacion) {

}
