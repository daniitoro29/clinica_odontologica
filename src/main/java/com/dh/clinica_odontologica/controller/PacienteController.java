package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.entity.Paciente;
import com.dh.clinica_odontologica.exception.ResourceNotFoundException;
import com.dh.clinica_odontologica.service.IPacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteServicio pacienteServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteServicio.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteServicio.guardar(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteServicio.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        pacienteServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPorId(@RequestBody Paciente paciente) {
        pacienteServicio.actualizar(paciente);
        return ResponseEntity.noContent().build();
    }
}
