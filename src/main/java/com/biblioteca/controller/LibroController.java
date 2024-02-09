package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.services.LibroServiceImpl;
import com.biblioteca.services.interfaces.LibroService;

import javax.swing.*;
import java.util.List;

public class LibroController {

    private final LibroService libroService;

    public LibroController() {
        libroService = new LibroServiceImpl();
    }


    public List<Libro> buscarLibroPorParametro(int itemSeleccionado, String parametroEntrada) {

        if (parametroEntrada.isBlank()) {
            JOptionPane.showMessageDialog(null, "Favor de llenar el campo de busqueda");
            throw new RuntimeException("Parametro vacío.");
        }

        List<Libro> libros = switch (itemSeleccionado) {
            case 0 -> libroService.buscarLibrosPorApellido(parametroEntrada);
            case 1 -> libroService.buscarLibrosPorNombre(parametroEntrada);
            case 2 -> libroService.buscarLibrosPorTitulo(parametroEntrada);
            default -> {
                JOptionPane.showMessageDialog(null, "Opción no disponible.");
                throw new RuntimeException();
            }
        };

        if (libros == null){
            JOptionPane.showMessageDialog(null, "No se encontrarón coincidencias.");
            throw new RuntimeException("Sin cincidencias");
        }

        return libros;
    }

    public Libro buscarLibroPorID(String identificador) {

        long id;
        try {
            id = Long.parseLong(identificador);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El id debe de ser númerico");
            throw new RuntimeException();
        }

        return libroService.buscarLibroPorID(id);
    }
}
