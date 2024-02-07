package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.services.LibroServiceImpl;
import com.biblioteca.services.interfaces.LibroService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerLibro {

    private final LibroService libroService;

    public ControllerLibro() {
        libroService = new LibroServiceImpl();
    }


    public List<Libro> buscarLibro(int itemSeleccionado, String parametroEntrada) {

        if (parametroEntrada.isBlank()) {
            JOptionPane.showMessageDialog(null, "Favor de llenar el campo de busqueda");
            throw new RuntimeException("Parametro vacío.");
        }

        List<Libro> libros;

        switch (itemSeleccionado) {

            case 0:
                libros = libroService.buscarLibrosPorApellido(parametroEntrada);
                break;

            case 1:
                libros = libroService.buscarLibrosPorNombre(parametroEntrada);
                break;

            case 2:
                libros = libroService.buscarLibrosPorTitulo(parametroEntrada);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción no disponible.");
                throw new RuntimeException();
        }

        if (libros == null){
            JOptionPane.showMessageDialog(null, "No se encontrarón coincidencias.");
            throw new RuntimeException("Sin cincidencias");
        }

        return libros;
    }
}
