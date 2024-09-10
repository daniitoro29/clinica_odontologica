package com.dh.clinica_odontologica.servicio;

import com.dh.clinica_odontologica.modelo.Odontologo;

import java.util.List;

public interface IOdontologoServicio {
    Odontologo guardar (Odontologo odontologo);
    Odontologo buscarPorId(Integer id);
    void eliminar(Integer id);
    void actualizar (Odontologo odontologo);
    List<Odontologo> listarTodos();
}
