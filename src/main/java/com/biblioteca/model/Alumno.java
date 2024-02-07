package com.biblioteca.model;

public class Alumno {

    private Long dni;
    private String nombre;
    private String apellido;
    private String periodo;
    private String grupo;

    public Alumno() {
    }

    public Alumno(Long dni, String nombre, String apellido, String periodo, String grupo) {
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
