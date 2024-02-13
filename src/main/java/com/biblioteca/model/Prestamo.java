package com.biblioteca.model;

import java.time.LocalDate;

@SuppressWarnings("all")
public class Prestamo {

    private Long id;
    private Alumno alumno;
    private Libro libro;
    private LocalDate fechaSolicitud;
    private LocalDate fechaEntrega;
    private Boolean estado;

    public Prestamo(Long id, Alumno alumno, Libro libro, LocalDate fechaSolicitud, LocalDate fechaEntrega, Boolean estado) {
        this.id = id;
        this.alumno = alumno;
        this.libro = libro;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
