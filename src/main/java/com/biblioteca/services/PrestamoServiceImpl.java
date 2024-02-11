package com.biblioteca.services;

import com.biblioteca.dao.PrestamoDAOImpl;
import com.biblioteca.dao.interfaces.PrestamoDAO;
import com.biblioteca.entities.AlumnoEntity;
import com.biblioteca.entities.AutorEntity;
import com.biblioteca.entities.LibroEntity;
import com.biblioteca.entities.PrestamoEntity;
import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.services.interfaces.PrestamoService;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoDAO prestamoDAO;

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

    @Override
    public List<String[]> buscarPrestamoPorID(String parametro) {

        return prestamoDAO.buscarPrestamoPorID(parametro);
    }

    @Override
    public List<String[]> buscarPrestamoPorTitulo(String parametro) {
        
        return prestamoDAO.buscarPrestamoPorTitulo(parametro);

    }

    @Override
    public String[] buscarPrestamoPorFolio(long folioPrestamo) {

        return prestamoDAO.buscarPrestamoPorFolio(folioPrestamo);
    }

    @Override
    public int actualizarPrestamo(long folioLong, LocalDate fechaEntrega) {

        if (fechaEntrega.isBefore(LocalDate.now())) {

            return prestamoDAO.actualizarPrestamo(folioLong);
        }

        return 0;
    }

    @Override
    public int actualizarPrestamoMultaUno(long folioLong, String motivo, LocalDate fechaEntrega) {
        return 0;
    }

    @Override
    public int actualizarPrestamoMultaDos(long folioLong, String motivo, LocalDate fechaEntrega) {
        return 0;
    }

    @Override
    public int actualizarPrestamoMultaTres(long folioLong, String motivo, LocalDate fechaEntrega) {
        return 0;
    }
}
