package com.biblioteca.services.interfaces;

import com.biblioteca.model.Alumno;

@SuppressWarnings("all")
public interface AlumnoServices {

    /**
     * Busca al alumno por su id
     * @param id {@link Long} id del alumno
     * @return Alumno
     */
    Alumno buscarAlumno(Long id);

}
