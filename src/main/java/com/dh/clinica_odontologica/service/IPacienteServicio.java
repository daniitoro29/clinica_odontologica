package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Paciente;

import java.util.List;

public interface IPacienteServicio {
    Paciente guardar(Paciente paciente);
    Paciente buscarPorId(Long id);
    void eliminar(Long id);
    void actualizar(Paciente paciente);
    List<Paciente> listarTodos();
}
