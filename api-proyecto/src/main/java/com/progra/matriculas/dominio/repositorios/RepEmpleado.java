package com.progra.matriculas.dominio.repositorios;

import com.progra.matriculas.dominio.entidades.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface RepEmpleado extends CrudRepository<Empleado, Long> { }
