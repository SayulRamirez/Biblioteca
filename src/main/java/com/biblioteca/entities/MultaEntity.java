package com.biblioteca.entities;

import javax.persistence.*;
import java.time.LocalDate;

@SuppressWarnings("all")
@Entity
@Table(name = "multas")
public class MultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivo;
    @Column(name = "inicio_multa")
    private LocalDate inicioMulta;
    @Column(name = "fin_multa")
    private LocalDate finMulta;
    @ManyToOne
    @JoinColumn(name = "alumno_dni")
    private AlumnoEntity alumno;
    private Boolean estado;

    public MultaEntity() {
    }

    public MultaEntity(Long id, String motivo, LocalDate inicioMulta, LocalDate finMulta, AlumnoEntity alumno) {
        this.id = id;
        this.motivo = motivo;
        this.inicioMulta = inicioMulta;
        this.finMulta = finMulta;
        this.alumno = alumno;
        this.estado = true;
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

    public AlumnoEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntity alumno) {
        this.alumno = alumno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
