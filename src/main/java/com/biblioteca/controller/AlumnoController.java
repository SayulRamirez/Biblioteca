package com.biblioteca.controller;

import com.biblioteca.model.Alumno;
import com.biblioteca.services.AlumnoServicesImpl;
import com.biblioteca.services.interfaces.AlumnoServices;

import javax.swing.*;

@SuppressWarnings("all")
public class AlumnoController {

    private final AlumnoServices alumnoServices;

    public AlumnoController() {
        alumnoServices = new AlumnoServicesImpl();
    }

    /**
     * Busca el alumno para verificar que se encuentre en el sistema
     * @param text DNI ingresado por el usuario
     * @return String indicando si el alumno se encuentra en el sistema o no
     */
    public Alumno buscarAlumno(String text) {

        long dni;

        try {
            dni = Long.parseLong(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El DNI solo debe de contener números.");
            throw new RuntimeException(e.getMessage());
        }

        return alumnoServices.buscarAlumno(dni);
    }
}
