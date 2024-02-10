package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.PrestamoEntity;

import java.util.ArrayList;
import java.util.List;

public interface PrestamoDAO {

    Long realizarPrestamo(PrestamoEntity prestamoEntity);

    List<String[]> buscarPrestamoPorID(String parametro);

    List<String[]> buscarPrestamoPorTitulo(String parametro);
}
