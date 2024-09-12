package com.dh.clinica_odontologica.service.Impl;

import com.dh.clinica_odontologica.entity.Turno;
import com.dh.clinica_odontologica.repository.ITurnoRepository;
import com.dh.clinica_odontologica.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServicioImpl implements ITurnoServicio {
    @Autowired
    private ITurnoRepository iTurnoRepository;


    @Override
    public Turno guardar(Turno turno) {
        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        Optional<Turno> turnoBuscado = iTurnoRepository.findById(id);
        return turnoBuscado.orElse(null);
    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }
}
