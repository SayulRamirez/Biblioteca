package com.biblioteca.controller;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.services.PrestamoServiceImpl;
import com.biblioteca.services.interfaces.PrestamoService;

public class PrestamoController {

    private PrestamoService prestamoService;

    public PrestamoController() {
        prestamoService = new PrestamoServiceImpl();
    }

    public Long realizarPrestamo(Alumno alumno, Libro libro) {

        return prestamoService.realizarPrestamo(alumno, libro);
    }
}
