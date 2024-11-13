package com.progra.matriculas.dominio.repositorios;

import com.progra.matriculas.dominio.entidades.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface RepTarea extends CrudRepository<Tarea, Long> { }
