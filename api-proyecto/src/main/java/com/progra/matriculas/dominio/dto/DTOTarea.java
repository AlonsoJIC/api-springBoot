package com.progra.matriculas.dominio.dto;

import java.time.LocalDateTime;

public record DTOTarea(long idTarea, String descripcion, String estado, LocalDateTime fechaAsignada) {

}
