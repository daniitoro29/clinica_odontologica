package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoServicio {
    Odontologo guardar (Odontologo odontologo);
    Odontologo buscarPorId(Long id);
    void eliminar(Long id);
    void actualizar (Odontologo odontologo);
    List<Odontologo> listarTodos();
}
