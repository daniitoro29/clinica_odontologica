package com.dh.clinica_odontologica.service.Impl;

import com.dh.clinica_odontologica.entity.Odontologo;
import com.dh.clinica_odontologica.entity.Turno;
import com.dh.clinica_odontologica.exception.ResourceBadRequestException;
import com.dh.clinica_odontologica.exception.ResourceNotFoundException;
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
        if (turno.getFecha() == null  || turno.getOdontologo() == null ) {
            throw new ResourceBadRequestException("Por favor revise la informacion que está enviando, los datos deben estar completos");
        }
        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        Optional<Turno> turnoBuscado  = iTurnoRepository.findById(id);
        if (turnoBuscado.isPresent()) {
            return turnoBuscado.get();
        } else {
            throw new ResourceNotFoundException("No se encontro el turno "+ id);
        }
    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }
}
