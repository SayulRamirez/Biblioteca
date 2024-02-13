package com.biblioteca.model;

@SuppressWarnings("all")
public class Autor {

    private Long id;
    private String nombre;
    private String apellido;

    public Autor(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
