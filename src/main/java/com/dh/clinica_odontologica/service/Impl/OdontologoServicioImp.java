package com.dh.clinica_odontologica.service.Impl;

import com.dh.clinica_odontologica.exception.ResourceNotFoundException;
import com.dh.clinica_odontologica.repository.IOdontologoRepository;
import com.dh.clinica_odontologica.service.IOdontologoServicio;
import com.dh.clinica_odontologica.entity.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServicioImp implements IOdontologoServicio {

    @Autowired
    private IOdontologoRepository iOdontologoRepository;


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Long id) throws  ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado  = iOdontologoRepository.findById(id);
        if (odontologoBuscado.isPresent()) {
            return odontologoBuscado.get();
        } else {
            throw new ResourceNotFoundException("No se encontro el odontologo con id "+ id);
        }
    }

    @Override
    public void eliminar(Long id) {
       iOdontologoRepository.deleteById(id);
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return iOdontologoRepository.findAll();
    }
}
