package com.progra.matriculas.controladores;

import org.springframework.web.bind.annotation.*;
import com.progra.matriculas.dominio.entidades.OrdenTrabajo;
import com.progra.matriculas.dominio.repositorios.RepOrdenTrabajo;
import java.util.Optional;

@RestController
@RequestMapping("/ordenes-trabajo")
@CrossOrigin
public class OrdenTrabajoController {
  private final RepOrdenTrabajo repOrdenTrabajo;

  public OrdenTrabajoController(RepOrdenTrabajo rep) {
    this.repOrdenTrabajo = rep;
  }

  @GetMapping
  public Iterable<OrdenTrabajo> listar() {
    return repOrdenTrabajo.findAll();
  }

  @GetMapping("{id}")
  public Optional<OrdenTrabajo> consultar(@PathVariable("id") Long idOrdenTrabajo) {
    return repOrdenTrabajo.findById(idOrdenTrabajo);
  }

  @PostMapping
  public boolean guardar(@RequestBody OrdenTrabajo ordenTrabajo) {
    repOrdenTrabajo.save(ordenTrabajo);
    return true;
  }

  @PutMapping
  public boolean actualizar(@RequestBody OrdenTrabajo ordenTrabajo) {
    OrdenTrabajo consulta = repOrdenTrabajo.findById(ordenTrabajo.getIdOrdenTrabajo()).orElse(null);
    if (consulta != null) {
        repOrdenTrabajo.save(ordenTrabajo);
        return true;
    }
    return false;
  }
}
