package com.biblioteca.services.interfaces;

import com.biblioteca.model.Libro;

import java.util.List;

public interface LibroService {

    /**
     * Busca los libro por el apellido o por las iniciales de el
     * @param apellido apellido del autor
     * @return Lista de libros
     */
    List<Libro> buscarLibrosPorApellido(String apellido);

    /**
     * Busca los libro por el nombre o por las iniciales de el
     * @param nombre apellido del autor
     * @return Lista de libros
     */
    List<Libro> buscarLibrosPorNombre(String nombre);

    /**
     * Busca los libro por el titulo del libro o por las iniciales de el
     * @param titulo titulo del libro
     * @return Lista de libros
     */
    List<Libro> buscarLibrosPorTitulo(String titulo);
}
