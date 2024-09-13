package com.dh.clinica_odontologica.service.impl;

import com.dh.clinica_odontologica.entity.Odontologo;
import com.dh.clinica_odontologica.exception.ResourceNotFoundException;
import com.dh.clinica_odontologica.repository.IOdontologoRepository;
import com.dh.clinica_odontologica.service.Impl.OdontologoServicioImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OdontologoServicioImpTest {

    @Mock
    private IOdontologoRepository iOdontologoRepository;

    @InjectMocks
    private OdontologoServicioImp odontologoServicioImp;

    private Odontologo odontologo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        odontologo = new Odontologo(1L, "Juan", "Pérez", "12345678");
    }

    @Test
    void guardar() {
        when(iOdontologoRepository.save(any(Odontologo.class))).thenReturn(odontologo);

        Odontologo odontologoGuardado = odontologoServicioImp.guardar(odontologo);

        assertEquals("Juan", odontologoGuardado.getNombre());

        verify(iOdontologoRepository, times(1)).save(odontologo);
    }

    @Test
    void buscarPorId() {
        when(iOdontologoRepository.findById(1L)).thenReturn(java.util.Optional.of(odontologo));

        Odontologo odontologoEncontrado = odontologoServicioImp.buscarPorId(1L);

        assertEquals("Juan", odontologoEncontrado.getNombre());

        verify(iOdontologoRepository, times(1)).findById(1L);
    }

  /* @Test
    void eliminar() {
    Odontologo odontologoGuardado = odontologoServicioImp.guardar(odontologo);
        odontologoServicioImp.eliminar(1L);
        verify(iOdontologoRepository, times(1)).deleteById(1L);
    }

     @Test
    void actualizar() {
    }

    @Test
    void listarTodos() {

    }*/
}
