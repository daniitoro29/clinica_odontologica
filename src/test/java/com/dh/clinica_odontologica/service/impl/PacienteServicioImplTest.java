package com.dh.clinica_odontologica.service.impl;

import com.dh.clinica_odontologica.entity.Odontologo;
import com.dh.clinica_odontologica.entity.Paciente;
import com.dh.clinica_odontologica.repository.IOdontologoRepository;
import com.dh.clinica_odontologica.repository.IPacienteRepository;
import com.dh.clinica_odontologica.service.Impl.OdontologoServicioImp;
import com.dh.clinica_odontologica.service.Impl.PacienteServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PacienteServicioImplTest {

    @Mock
    private IPacienteRepository iPacienteRepository;

    @InjectMocks
    private PacienteServicioImpl pacienteServicio;

    private Paciente paciente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        paciente = new Paciente(1L, "Juan", "Pérez", "12345678", null);
    }

    @Test
    void guardar() {
        when(iPacienteRepository.save(any(Paciente.class))).thenReturn(paciente);

        Paciente pacienteGuardado = pacienteServicio.guardar(paciente);

        assertEquals("Juan", pacienteGuardado.getNombre());

        verify(iPacienteRepository, times(1)).save(paciente);
    }

    @Test
    void buscarPorId() {
        when(iPacienteRepository.findById(1L)).thenReturn(java.util.Optional.of(paciente));

        Paciente pacienteEncontrado = pacienteServicio.buscarPorId(1L);

        assertEquals("Juan", pacienteEncontrado.getNombre());

        verify(iPacienteRepository, times(1)).findById(1L);
    }
}