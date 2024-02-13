package com.biblioteca.model;

@SuppressWarnings("all")
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

    public String getApellido() {
        return apellido;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getGrupo() {return grupo;}

}
