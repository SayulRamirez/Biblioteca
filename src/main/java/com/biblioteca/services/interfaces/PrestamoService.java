package com.biblioteca.services.interfaces;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;

public interface PrestamoService {

    Long realizarPrestamo(Alumno alumno, Libro libro);
}
