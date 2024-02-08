package com.biblioteca.entities;


import javax.persistence.*;

@Entity
@Table(name = "libros")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    @Column(name = "autor_id")
    private AutorEntity autor;
    @Column(name = "num_existencias")
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
