package com.biblioteca.services.interfaces;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;

public interface PrestamoService {

    Long realizarPrestamo(Alumno alumno, Libro libro);

    List<String[]> buscarPrestamoPorID(String parametro);

    List<String[]> buscarPrestamoPorTitulo(String parametro);
}
