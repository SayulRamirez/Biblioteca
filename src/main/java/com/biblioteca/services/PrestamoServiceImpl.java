package com.biblioteca.services;

import com.biblioteca.dao.PrestamoDAOImpl;
import com.biblioteca.dao.interfaces.PrestamoDAO;
import com.biblioteca.entities.AlumnoEntity;
import com.biblioteca.entities.AutorEntity;
import com.biblioteca.entities.LibroEntity;
import com.biblioteca.entities.PrestamoEntity;
import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.services.interfaces.PrestamoService;

import java.time.LocalDate;

public class PrestamoServiceImpl implements PrestamoService {

    public PrestamoDAO prestamoDAO;

    public PrestamoServiceImpl() {
        prestamoDAO = new PrestamoDAOImpl();
    }

    @Override
    public Long realizarPrestamo(Alumno alumno, Libro libro) {

        AlumnoEntity alumnoEntity = new AlumnoEntity(alumno.getDni(), alumno.getNombre(), alumno.getApellido(), alumno.getPeriodo(), alumno.getGrupo());

        LibroEntity libroEntity = new LibroEntity(libro.getId(), libro.getTitulo(), libro.getNumeroExistencias(), new AutorEntity(libro.getAutor().getId(), libro.getAutor().getNombre(), libro.getAutor().getApellido()));

        LocalDate inicioPrestamo = LocalDate.now();

        LocalDate fechaEntrega = inicioPrestamo.plusDays(15);

        PrestamoEntity prestamoEntity = new PrestamoEntity(null, alumnoEntity, libroEntity, inicioPrestamo, fechaEntrega);

        return prestamoDAO.realizarPrestamo(prestamoEntity);
    }
}
