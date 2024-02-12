package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.MultaEntity;

import java.time.LocalDate;

public interface MultaDAO {
    MultaEntity buscarMultaPorAlumno(long dni);

    void actualizarMultas(LocalDate ahora);
}
