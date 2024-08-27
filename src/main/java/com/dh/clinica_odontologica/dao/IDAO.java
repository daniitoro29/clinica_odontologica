package com.dh.clinica_odontologica.dao;

import java.util.List;

public interface IDAO<T> {
    T guardar (T t);
    List<T> listarTodos();
    T consultarPorId(Integer id);
    void eliminarPorId(Integer id);
    T actualizar(T t);
}
