package com.biblioteca.controller;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.services.PrestamoServiceImpl;
import com.biblioteca.services.interfaces.PrestamoService;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("all")
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
        Long folioPrestamo = isLong(folio);
        if (folioPrestamo == null) return null;

        return prestamoService.buscarPrestamoPorFolio(folioPrestamo);
    }

    public int actualizarPrestamo(String folio, boolean seleccionado, String motivo, int posicionMotivo, LocalDate fechaEntrega) {

        int resultado = 0;
        Long folioPrestamo = isLong(folio);

        if (seleccionado) {
            switch (posicionMotivo){
                case 0 -> resultado = prestamoService.actualizarPrestamoMultaUno(folioPrestamo, motivo, fechaEntrega);
                case 1 -> resultado = prestamoService.actualizarPrestamoMultaDos(folioPrestamo, motivo, fechaEntrega);
                case 2 -> resultado = prestamoService.actualizarPrestamoMultaTres(folioPrestamo, motivo, fechaEntrega);
            }

        } else {

            resultado = prestamoService.actualizarPrestamo(folioPrestamo, fechaEntrega);
        }

        return resultado;
    }

    public Prestamo buscarPrestamoPorAlumno(String dni) {

        Long dniAlumno = isLong(dni);

        return prestamoService.buscarPrestamoPorAlumno(dniAlumno);
    }

    private static Long isLong(String folio) {
        long folioPrestamo;
        try {
            folioPrestamo = Long.parseLong(folio);
        } catch (NumberFormatException e) {
            return null;
        }
        return folioPrestamo;
    }
}
