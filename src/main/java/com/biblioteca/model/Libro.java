package com.biblioteca.model;

@SuppressWarnings("all")
public class Libro {

    private Long id;
    private String titulo;
    private Autor autor;
    private Integer numeroExistencias;

    public Libro() {
    }

    public Libro(Long id, String titulo, Autor autor, Integer numeroExistencias) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroExistencias = numeroExistencias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Integer getNumeroExistencias() {
        return numeroExistencias;
    }
}
