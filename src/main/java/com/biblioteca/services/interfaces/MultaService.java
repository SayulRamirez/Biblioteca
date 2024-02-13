package com.biblioteca.services.interfaces;

import com.biblioteca.model.Multa;

@SuppressWarnings("all")
public interface MultaService {

    /**
     * Busca una multa por el DNI del alumno
     * @param dni {@link Long} DNI del alumno
     * @return Multa
     */
    Multa buscarMultaPorAlumno(long dni);

    /**
     * Actualiza el estado de todas las multas
     */
    void actualizarMultas();
}
