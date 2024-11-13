package com.progra.matriculas.controladores;

import org.springframework.web.bind.annotation.*;
import com.progra.matriculas.dominio.entidades.Tarea;
import com.progra.matriculas.dominio.repositorios.RepTarea;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
@CrossOrigin
public class TareaController {
  private final RepTarea repTarea;

  public TareaController(RepTarea rep) {
    this.repTarea = rep;
  }

  @GetMapping
  public Iterable<Tarea> listar() {
    return repTarea.findAll();
  }

  @GetMapping("{id}")
  public Optional<Tarea> consultar(@PathVariable("id") Long idTarea) {
    return repTarea.findById(idTarea);
  }

  @PostMapping
  public boolean guardar(@RequestBody Tarea tarea) {
    repTarea.save(tarea);
    return true;
  }

  @PutMapping
  public boolean actualizar(@RequestBody Tarea tarea) {
    Tarea consulta = repTarea.findById(tarea.getIdTarea()).orElse(null);
    if (consulta != null) {
        repTarea.save(tarea);
        return true;
    }
    return false;
  }

  @PatchMapping
  public boolean cambiarEstado(@RequestBody Tarea tarea) {
    Tarea obTarea = repTarea.findById(tarea.getIdTarea()).orElse(null);
    if (obTarea != null) {
      obTarea.setEstado(tarea.getEstado());
      repTarea.save(obTarea);
      return true;
    }
    return false;
  }
}
