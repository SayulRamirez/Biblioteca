package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.LibroEntity;
import com.biblioteca.model.Libro;

import java.util.List;

public interface LibroDAO {

    /**
     * Busca los libro por el apellido o por las iniciales de el
     * @param apellido apellido del autor
     * @return Lista de libros
     */
    List<LibroEntity> buscarLibrosPorApellido(String apellido);

    /**
     * Busca los libro por el nombre o por las iniciales de el
     * @param nombre apellido del autor
     * @return Lista de libros
     */
    List<LibroEntity> buscarLibrosPorNombre(String nombre);

    /**
     * Busca los libro por el titulo del libro o por las iniciales de el
     * @param titulo titulo del libro
     * @return Lista de libros
     */
    List<LibroEntity> buscarLibrosPorTitulo(String titulo);
}
