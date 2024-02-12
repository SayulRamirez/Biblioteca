package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.MultaEntity;

public interface MultaDAO {
    MultaEntity buscarMultaPorAlumno(long dni);
}
