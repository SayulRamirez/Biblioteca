package com.biblioteca.controller;

import com.biblioteca.model.Multa;
import com.biblioteca.services.MultaServiceImpl;
import com.biblioteca.services.interfaces.MultaService;

@SuppressWarnings("all")
public class MultaController {

    private final MultaService multaService;

    public MultaController() {
        multaService = new MultaServiceImpl();
    }

    public Multa buscarMulta(String dni) {

        long dniAlumno;

        try {
           dniAlumno = Long.parseLong(dni);
        } catch (NumberFormatException e) {
            return null;
        }

        return multaService.buscarMultaPorAlumno(dniAlumno);
    }

    public void actualizarMultas() {

        multaService.actualizarMultas();
    }
}
