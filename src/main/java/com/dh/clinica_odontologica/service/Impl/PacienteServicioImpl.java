package com.dh.clinica_odontologica.service.Impl;

import com.dh.clinica_odontologica.entity.Paciente;
import com.dh.clinica_odontologica.exception.PacienteNotFoundException;
import com.dh.clinica_odontologica.repository.IPacienteRepository;
import com.dh.clinica_odontologica.service.IPacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServicioImpl implements IPacienteServicio {

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Override
    public Paciente guardar(Paciente paciente) {
        return iPacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id) throws PacienteNotFoundException {
        Optional<Paciente> pacienteBuscado = iPacienteRepository.findById(id);
        if (pacienteBuscado.isPresent()) {
            return pacienteBuscado.get();
        } else {
            throw new PacienteNotFoundException("No se encontró el paciente con id: " + id);
        }
    }

    @Override
    public List<Paciente> listarTodos() {
        return iPacienteRepository.findAll();
    }

    @Override
    public void eliminar(Long id) throws PacienteNotFoundException {
        if (iPacienteRepository.existsById(id)) {
            iPacienteRepository.deleteById(id);
        } else {
            throw new PacienteNotFoundException("No se pudo eliminar. El paciente con id: " + id + " no existe.");
        }
    }

    @Override
    public void actualizar(Paciente paciente) throws PacienteNotFoundException {
        if (iPacienteRepository.existsById(paciente.getId())) {
            iPacienteRepository.save(paciente);
        } else {
            throw new PacienteNotFoundException("No se pudo actualizar. El paciente con id: " + paciente.getId() + " no existe.");
        }
    }
}
