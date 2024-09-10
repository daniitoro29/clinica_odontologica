package com.dh.clinica_odontologica.dao.Impl;


import com.dh.clinica_odontologica.dao.DB;
import com.dh.clinica_odontologica.dao.IDAO;
import com.dh.clinica_odontologica.modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionOdontologo implements IDAO<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(ImplementacionOdontologo.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS(Nombre, Apellido, Matricula) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while(rs.next()){
                odontologo.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        Odontologo odontologo = null;
        List<Odontologo> odontologoList = new ArrayList<>();
        try {
            connection = DB.getConnection();
            Statement buscarTodos = connection.createStatement();
            ResultSet rs = buscarTodos.executeQuery("SELECT * FROM ODONTOLOGOS");
            while(rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                odontologoList.add(odontologo);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologoList;
    }

    @Override
    public Odontologo consultarPorId(Integer id) {
        Connection connection = null;
        Odontologo odontologo = null;
        try {
            connection = DB.getConnection();
            PreparedStatement psBuscarPorId = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS WHERE ID=?");
            psBuscarPorId.setInt(1,id);
            ResultSet rs = psBuscarPorId.executeQuery();
            while(rs.next()){
                odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setNombre(rs.getString(2));
                odontologo.setApellido(rs.getString(3));
                odontologo.setMatricula(rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement eliminarId = connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            eliminarId.setInt(1,id);
            eliminarId.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ODONTOLOGOS " +
                    "SET NOMBRE=?, APELLIDO=?, MATRICULA=? WHERE ID=?");

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2,odontologo.getApellido());
            preparedStatement.setString(3,odontologo.getMatricula());
            preparedStatement.setInt(4, odontologo.getId());


            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }
}
