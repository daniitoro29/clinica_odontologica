package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.modelo.Odontologo;
import com.dh.clinica_odontologica.servicio.IOdontologoServicio;
import com.dh.clinica_odontologica.servicio.Impl.OdontologoServicioImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {
    private IOdontologoServicio odontologoServicio;

    public OdontologoController(){
        this.odontologoServicio = new OdontologoServicioImp();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id) {
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
    public ResponseEntity<Void> eliminarPorId(@PathVariable Integer id){
        odontologoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> actualizarPorId(@RequestBody Odontologo odontologo) {
        odontologoServicio.actualizar(odontologo);
        return ResponseEntity.noContent().build();
    }
}
