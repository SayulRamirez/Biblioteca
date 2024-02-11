package com.biblioteca.services.interfaces;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoService {

    Long realizarPrestamo(Alumno alumno, Libro libro);

    List<String[]> buscarPrestamoPorID(String parametro);

    List<String[]> buscarPrestamoPorTitulo(String parametro);

    String[] buscarPrestamoPorFolio(long folioPrestamo);

    int actualizarPrestamo(long folioLong, LocalDate fechaEntrega);

    int actualizarPrestamoMultaUno(long folio, String motivo, LocalDate fechaEntrega);

    int actualizarPrestamoMultaDos(long folio, String motivo, LocalDate fechaEntrega);

    int actualizarPrestamoMultaTres(long folio, String motivo, LocalDate fechaEntrega);
}
