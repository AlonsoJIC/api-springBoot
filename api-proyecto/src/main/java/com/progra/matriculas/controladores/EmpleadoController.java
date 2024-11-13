package com.progra.matriculas.controladores;

import org.springframework.web.bind.annotation.*;
import com.progra.matriculas.dominio.entidades.Empleado;
import com.progra.matriculas.dominio.repositorios.RepEmpleado;
import java.util.Optional;

@RestController
@RequestMapping("empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {
    private final RepEmpleado repEmpleado;

    public EmpleadoController(RepEmpleado rep) {
        this.repEmpleado = rep;
    }

    @GetMapping
    public Iterable<Empleado> listar() {
        return repEmpleado.findAll();
    }

    @GetMapping("{id}")
    public Optional<Empleado> consultar(@PathVariable("id") Long idEmpleado) {
        return repEmpleado.findById(idEmpleado);
    }

    @PostMapping
    public boolean guardar(@RequestBody Empleado empleado) {
        repEmpleado.save(empleado);
        return true;
    }

    @PutMapping
    public boolean actualizar(@RequestBody Empleado empleado) {
        Empleado consulta = repEmpleado.findById(empleado.getIdEmpleado()).orElse(null);
        if (consulta != null) {
            repEmpleado.save(empleado);
            return true;
        }
        return false;
    }

    @PatchMapping
    public boolean cambiarEstado(@RequestBody Empleado empleado) {
        Empleado obEmpleado = repEmpleado.findById(empleado.getIdEmpleado()).orElse(null);
        if (obEmpleado != null) {
            obEmpleado.setEstado(empleado.getEstado());
            repEmpleado.save(obEmpleado);
            return true;
        }
        return false;
    }
}