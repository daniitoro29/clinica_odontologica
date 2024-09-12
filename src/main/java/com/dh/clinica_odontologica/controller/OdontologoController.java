package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.entity.Odontologo;
import com.dh.clinica_odontologica.service.IOdontologoServicio;
import com.dh.clinica_odontologica.service.Impl.OdontologoServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {
    @Autowired
    private IOdontologoServicio odontologoServicio;

    public OdontologoController(){
        this.odontologoServicio = new OdontologoServicioImp();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(odontologoServicio.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoServicio.guardar(odontologo));
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoServicio.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        odontologoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> actualizarPorId(@RequestBody Odontologo odontologo) {
        odontologoServicio.actualizar(odontologo);
        return ResponseEntity.noContent().build();
    }
}
