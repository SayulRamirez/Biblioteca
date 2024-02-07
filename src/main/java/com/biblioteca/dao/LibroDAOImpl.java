package com.biblioteca.dao;

import com.biblioteca.dao.interfaces.LibroDAO;
import com.biblioteca.entities.LibroEntity;

import java.util.List;

public class LibroDAOImpl implements LibroDAO {


    @Override
    public List<LibroEntity> buscarLibrosPorApellido(String apellido) {
        return null;
    }

    @Override
    public List<LibroEntity> buscarLibrosPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<LibroEntity> buscarLibrosPorTitulo(String titulo) {
        return null;
    }
}
