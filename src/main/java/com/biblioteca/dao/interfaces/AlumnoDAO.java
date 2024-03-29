package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.AlumnoEntity;

@SuppressWarnings("all")
public interface AlumnoDAO {

    /**
     * Busca un alumno por su DNI
     * @param dni Long
     * @return AlumnoEntity
     */
    AlumnoEntity finbyDni(Long dni);
}
