package com.biblioteca.controller;

import com.biblioteca.services.AlumnoServicesImpl;
import com.biblioteca.services.interfaces.AlumnoServices;

import javax.swing.*;

public class AlumnoController {

    private AlumnoServices as;

    public AlumnoController() {
        as = new AlumnoServicesImpl();
    }

    public String estaVerificado(String text) {

        long dni;

        try {
            dni = Long.parseLong(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El DNI solo debe de contener números.");
            throw new RuntimeException(e.getMessage());
        }

        return as.buscarAlumno(dni);
    }
}
