package com.biblioteca.services;

import com.biblioteca.dao.LibroDAOImpl;
import com.biblioteca.dao.interfaces.LibroDAO;
import com.biblioteca.entities.LibroEntity;
import com.biblioteca.model.Autor;
import com.biblioteca.model.Libro;
import com.biblioteca.services.interfaces.LibroService;

import java.util.ArrayList;
import java.util.List;

public class LibroServiceImpl implements LibroService {

    private final LibroDAO libroDAO;
    private List<Libro> libros;

    public LibroServiceImpl() {
        libroDAO = new LibroDAOImpl();
    }


    @Override
    public List<Libro> buscarLibrosPorApellido(String apellido) {

        libros = new ArrayList<>();

        List<LibroEntity> libroEntities = libroDAO.buscarLibrosPorApellido(apellido);

        if (libroEntities == null) return null;

        entitiesAModel(libroEntities);

        return libros;

    }

    @Override
    public List<Libro> buscarLibrosPorNombre(String nombre) {
        libros = new ArrayList<>();

        List<LibroEntity> libroEntities = libroDAO.buscarLibrosPorNombre(nombre);

        if (libroEntities == null) return null;

        entitiesAModel(libroEntities);

        return libros;
    }

    @Override
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        libros = new ArrayList<>();

        List<LibroEntity> libroEntities = libroDAO.buscarLibrosPorTitulo(titulo);

        if (libroEntities == null) return null;

        entitiesAModel(libroEntities);

        return libros;
    }

    @Override
    public Libro buscarLibroPorID(Long id) {

        LibroEntity libroEntity = libroDAO.buscarLibroPorID(id);

        if (libroEntity == null) return null;

        return new Libro(libroEntity.getId(),
                         libroEntity.getTitulo(),
                                new Autor(libroEntity.getAutorEntity().getId(),
                                          libroEntity.getAutorEntity().getNombre(),
                                          libroEntity.getAutorEntity().getApellido()),
                         libroEntity.getNumeroExistencias());
    }

    private void entitiesAModel(List<LibroEntity> libroEntities) {
        libroEntities.forEach(
                libroEntity -> libros.add(
                        new Libro(libroEntity.getId(),
                                  libroEntity.getTitulo(),
                                        new Autor(libroEntity.getId(),
                                                  libroEntity.getAutorEntity().getNombre(),
                                                  libroEntity.getAutorEntity().getApellido()),
                                  libroEntity.getNumeroExistencias())));
    }
}
