package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.PrestamoEntity;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoDAO {

    Long realizarPrestamo(PrestamoEntity prestamoEntity);

    List<String[]> buscarPrestamoPorID(String parametro);

    List<String[]> buscarPrestamoPorTitulo(String parametro);

    String[] buscarPrestamoPorFolio(long folioPrestamo);

    int actualizarPrestamo(long folioLong);

    int actualizarPrestamoMulta(long folio, String motivo, LocalDate fechaInicial, LocalDate fehcaFinal);
}
