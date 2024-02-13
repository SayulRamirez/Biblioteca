package com.biblioteca.dao.interfaces;

import com.biblioteca.entities.PrestamoEntity;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("all")
public interface PrestamoDAO {

    /**
     * Realiza el prestamo de un libro
     * @param prestamoEntity {@link PrestamoEntity}
     * @return Long número de folio o identificador del prestamo
     */
    Long realizarPrestamo(PrestamoEntity prestamoEntity);

    /**
     * Busca un libro prestado por el id del libro
     * @param parametro {@link Long} id
     * @return Los datos especificados en el store procedure
     */
    List<String[]> buscarPrestamoPorID(Long parametro);

    /**
     * Busca los libros prestados por el titulo del libro
     * @param parametro {@link String} titulo del libro
     * @return datos especificados en el store procedure
     */
    List<String[]> buscarPrestamoPorTitulo(String parametro);

    /**
     * Busca el prestamo por número de folio
     * @param folioPrestamo Long folio o id del prestamo
     * @return datos especificados por el store procedure
     */
    String[] buscarPrestamoPorFolio(long folioPrestamo);

    /**
     * Actualiza el estado del prestamo cuando se hace la devolución
     * @param folio folio o id del prestamo
     * @return 1 si la transacción se realizó correctamente y 0 si no
     */
    int actualizarPrestamo(long folio);

    /**
     * Actualiza un prestamo y agrega la multa correspondiente
     * @param folio Long folio o id del prestamo
     * @param motivo {@link String} motivo de la multa
     * @param fechaInicial {@link LocalDate} fecha en que inicia la multa
     * @param fehcaFinal {@link LocalDate} fecha en que finaliza la multa
     * @return 1 si la transacción se realizó correctamente y 0 si no
     */
    int actualizarPrestamoMulta(long folio, String motivo, LocalDate fechaInicial, LocalDate fehcaFinal);

    /**
     * Busca un prestamo por el DNI del alumno
     * @param dni {@link Long} dni del alumno
     * @return PrestamoEntity
     */
    PrestamoEntity buscarPrestamoPorDni(Long dni);
}
