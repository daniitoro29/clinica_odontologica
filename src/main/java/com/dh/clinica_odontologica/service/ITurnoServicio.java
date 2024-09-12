package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Turno;

import java.util.List;

public interface ITurnoServicio {

    Turno guardar(Turno turno);
    Turno buscarPorId(Long id);
    List<Turno> listarTodos();

}
