package com.biblioteca.model;

import java.time.LocalDate;

public class Multa {

    private Long id;
    private String motivo;
    private LocalDate inicioMulta;
    private LocalDate finMulta;
    private Alumno alumno;
    private Boolean estado;

    public Multa(){}

    public Multa(Long id, String motivo, LocalDate inicioMulta, LocalDate finMulta, Alumno alumno, Boolean estado) {
        this.id = id;
        this.motivo = motivo;
        this.inicioMulta = inicioMulta;
        this.finMulta = finMulta;
        this.alumno = alumno;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getInicioMulta() {
        return inicioMulta;
    }

    public void setInicioMulta(LocalDate inicioMulta) {
        this.inicioMulta = inicioMulta;
    }

    public LocalDate getFinMulta() {
        return finMulta;
    }

    public void setFinMulta(LocalDate finMulta) {
        this.finMulta = finMulta;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
