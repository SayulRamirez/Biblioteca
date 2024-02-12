package com.biblioteca.services.interfaces;

import com.biblioteca.model.Multa;

public interface MultaService {

    public Multa buscarMultaPorAlumno(long dni);

    void actualizarMultas();
}
