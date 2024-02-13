package com.biblioteca.entities;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("all")
@Entity
@Table(name = "alumnos")
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dni;
    private String nombre;
    private String apellido;
    private String periodo;
    private String grupo;
    @OneToMany(mappedBy = "alumno")
    private Set<PrestamoEntity> prestamos;
    @OneToMany(mappedBy = "alumno")
    private Set<MultaEntity> multas;

    public AlumnoEntity() {
    }

    public AlumnoEntity(Long dni, String nombre, String apellido, String periodo, String grupo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.periodo = periodo;
        this.grupo = grupo;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
