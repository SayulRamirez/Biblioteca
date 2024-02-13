package com.biblioteca.services.interfaces;

import com.biblioteca.model.Alumno;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("all")
public interface PrestamoService {

    /**
     * Realiza un prestamo
     * @param alumno {@link Alumno}
     * @param libro {@link Libro}
     * @return Long folio o id del prestamo
     */
    Long realizarPrestamo(Alumno alumno, Libro libro);

    /**
     * Busca un prestamo por el id del libro
     * @param parametro {@link String} id del libro
     * @return List de los datos devueltos por el store procedure de la base de datos
     */
    List<String[]> buscarPrestamoPorID(String parametro);

    /**
     * Buscar un prestamo por el titulo del libro
     * @param parametro {@link String} titulo del libro
     * @return List de los datos devueltos por el store procedure de la base de datos
     */
    List<String[]> buscarPrestamoPorTitulo(String parametro);

    /**
     * Busca un prestamo por el folio o id del prestamo
     * @param folioPrestamo {@link Long} folio o id del prestamo
     * @return Array de los datos devueltos por el store procedure de la base de datos
     */
    String[] buscarPrestamoPorFolio(long folioPrestamo);

    /**
     * Actualiza el estado del prestamo
     * @param folioLong {@link Long} id o folio del prestamo
     * @param fechaEntrega {@link LocalDate} fecha en que debería de haber sido entregado
     * @return int 1 si se actualizó correctamente o 0 si no lo hizó
     */
    int actualizarPrestamo(long folioLong, LocalDate fechaEntrega);

    /**
     * Actializa el estado del prestamo y agrega la correspondiente multa
     * @param folio {@link Long} folio o id del prestamo
     * @param motivo {@link String} motivo de la multa
     * @param fechaEntrega {@link LocalDate} fecha en que debería de haberse entregado el prestamo
     * @return int 1 si se actualizó correctamente o 0 si no lo hizó
     */
    int actualizarPrestamoMultaUno(long folio, String motivo, LocalDate fechaEntrega);

    /**
     * Actializa el estado del prestamo y agrega la correspondiente multa
     * @param folio {@link Long} folio o id del prestamo
     * @param motivo {@link String} motivo de la multa
     * @param fechaEntrega {@link LocalDate} fecha en que debería de haberse entregado el prestamo
     * @return int 1 si se actualizó correctamente o 0 si no lo hizó
     */
    int actualizarPrestamoMultaDos(long folio, String motivo, LocalDate fechaEntrega);

    /**
     * Actializa el estado del prestamo y agrega la correspondiente multa
     * @param folio {@link Long} folio o id del prestamo
     * @param motivo {@link String} motivo de la multa
     * @param fechaEntrega {@link LocalDate} fecha en que debería de haberse entregado el prestamo
     * @return int 1 si se actualizó correctamente o 0 si no lo hizó
     */
    int actualizarPrestamoMultaTres(long folio, String motivo, LocalDate fechaEntrega);

    /**
     * Busca el prestamo por el DNI del alumno
     * @param dni {@link Long} dni del alumno
     * @return Prestamo
     */
    Prestamo buscarPrestamoPorAlumno(Long dni);
}
