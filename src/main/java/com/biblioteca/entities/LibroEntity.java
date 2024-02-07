package com.biblioteca.entities;


public class LibroEntity {

    private Long id;
    private String titulo;
    private AutorEntity autor;
    private Integer numeroExistencias;

    public LibroEntity() {
    }

    public LibroEntity(Long id, String titulo, AutorEntity autor, Integer numeroExistencias) {
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

    public AutorEntity getAutorEntity() {
        return autor;
    }

    public void setAutor(AutorEntity autor) {
        this.autor = autor;
    }

    public Integer getNumeroExistencias() {
        return numeroExistencias;
    }

    public void setNumeroExistencias(Integer numeroExistencias) {
        this.numeroExistencias = numeroExistencias;
    }
}
