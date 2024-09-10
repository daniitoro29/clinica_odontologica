package com.dh.clinica_odontologica.servicio.Impl;

import com.dh.clinica_odontologica.dao.IDAO;
import com.dh.clinica_odontologica.dao.Impl.ImplementacionOdontologo;
import com.dh.clinica_odontologica.servicio.IOdontologoServicio;
import com.dh.clinica_odontologica.modelo.Odontologo;

import java.util.List;

public class OdontologoServicioImp implements IOdontologoServicio {
    private IDAO<Odontologo> odontologoIDAO;

    public OdontologoServicioImp() {
        this.odontologoIDAO = new ImplementacionOdontologo();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDAO.guardar(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return odontologoIDAO.consultarPorId(id);
    }

    @Override
    public void eliminar(Integer id) {
        odontologoIDAO.eliminarPorId(id);
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        odontologoIDAO.actualizar(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologoIDAO.listarTodos();
    }
}
