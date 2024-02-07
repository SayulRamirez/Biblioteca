package com.biblioteca.model;

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

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Integer getNumeroExistencias() {
        return numeroExistencias;
    }

    public void setNumeroExistencias(Integer numeroExistencias) {
        this.numeroExistencias = numeroExistencias;
    }
}
