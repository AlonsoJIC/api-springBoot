package com.progra.matriculas.controladores;

import org.springframework.web.bind.annotation.*;
import com.progra.matriculas.dominio.entidades.EstadoOrden;
import com.progra.matriculas.dominio.repositorios.RepEstadoOrden;
import java.util.Optional;

@RestController
@RequestMapping("/estados-orden")
@CrossOrigin
public class EstadoOrdenController {
  private final RepEstadoOrden repEstadoOrden;

  public EstadoOrdenController(RepEstadoOrden rep) {
    this.repEstadoOrden = rep;
  }

  @GetMapping
  public Iterable<EstadoOrden> listar() {
    return repEstadoOrden.findAll();
  }

  @GetMapping("{id}")
  public Optional<EstadoOrden> consultar(@PathVariable("id") Long idEstadoOrden) {
    return repEstadoOrden.findById(idEstadoOrden);
  }

  @PostMapping
  public boolean guardar(@RequestBody EstadoOrden estadoOrden) {
    repEstadoOrden.save(estadoOrden);
    return true;
  }

  @PutMapping
  public boolean actualizar(@RequestBody EstadoOrden estadoOrden) {
    EstadoOrden consulta = repEstadoOrden.findById(estadoOrden.getIdEstadoOrden()).orElse(null);
    if (consulta != null) {
        repEstadoOrden.save(estadoOrden);
        return true;
    }
    return false;
  }
}
