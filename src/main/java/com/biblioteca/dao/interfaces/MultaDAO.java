package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.MultaEntity;

import java.time.LocalDate;

@SuppressWarnings("all")
public interface MultaDAO {

    /**
     * Busca una multa por el DNI del alumno
     * @param dni {@link Long} dni del alumno
     * @return MultaEntity
     */
    MultaEntity buscarMultaPorAlumno(long dni);

    /**
     * Actualiza el estado de de las multas
     * @param ahora {@link LocalDate} fecha actual
     */
    void actualizarMultas(LocalDate ahora);
}
