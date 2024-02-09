package com.biblioteca.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "libros")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;
    @Column(name = "num_existencias")
    private Integer numeroExistencias;
    @OneToMany(mappedBy = "libro")
    private Set<PrestamoEntity> prestamos;

    public LibroEntity() {
    }

    public LibroEntity(Long id, String titulo, Integer existencias, AutorEntity autor) {
        this.id = id;
        this.titulo = titulo;
        this.numeroExistencias = existencias;
        this.autor = autor;
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
