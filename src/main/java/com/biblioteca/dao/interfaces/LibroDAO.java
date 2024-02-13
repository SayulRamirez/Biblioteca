package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.LibroEntity;

import java.util.List;

@SuppressWarnings("all")
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

    /**
     * Busca un libro por el id
     * @param id {@link Long}
     * @return Libro
     */
    LibroEntity buscarLibroPorID(Long id);
}
