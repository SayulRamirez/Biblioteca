package com.biblioteca.controller;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.services.PrestamoServiceImpl;
import com.biblioteca.services.interfaces.PrestamoService;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoController {

    private final PrestamoService prestamoService;

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

    public String[] buscarPrestamoPorFolio(String folio) {
        long folioPrestamo;
        try {
            folioPrestamo = Long.parseLong(folio);
        } catch (NumberFormatException e) {
            return null;
        }

        return prestamoService.buscarPrestamoPorFolio(folioPrestamo);
    }

    public int actualizarPrestamo(String folio, boolean seleccionado, String motivo, int posicionMotivo, LocalDate fechaEntrega) {

        long folioLong;
        int resultado = 0;

        try {
            folioLong = Long.parseLong(folio);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (seleccionado) {
            switch (posicionMotivo){
                case 0 -> resultado = prestamoService.actualizarPrestamoMultaUno(folioLong, motivo, fechaEntrega);
                case 1 -> resultado = prestamoService.actualizarPrestamoMultaDos(folioLong, motivo, fechaEntrega);
                case 2 -> resultado = prestamoService.actualizarPrestamoMultaTres(folioLong, motivo, fechaEntrega);
            }

        } else {

            resultado = prestamoService.actualizarPrestamo(folioLong, fechaEntrega);
        }

        return resultado;
    }
}
