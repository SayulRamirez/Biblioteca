package com.biblioteca.controller;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.services.PrestamoServiceImpl;
import com.biblioteca.services.interfaces.PrestamoService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoController {

    private PrestamoService prestamoService;

    public PrestamoController() {
        prestamoService = new PrestamoServiceImpl();
    }

    public Long realizarPrestamo(Alumno alumno, Libro libro) {

        return prestamoService.realizarPrestamo(alumno, libro);
    }

    public List<String[]> buscarPrestamo(int opcion, String parametro) {
        List<String[]> prestamos = null;

        switch (opcion) {
            case 0 -> prestamos = prestamoService.buscarPrestamoPorID(parametro);
            case 1 -> prestamos = prestamoService.buscarPrestamoPorTitulo(parametro);
            default -> JOptionPane.showMessageDialog(null, "Opción invalida.");
        }
        return prestamos;
    }
}
