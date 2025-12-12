package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lecciones")
public class Leccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLeccion")
    private Integer idLeccion;
    
    @Column(name = "Titulo", length = 150)
    private String titulo;
    
    @Column(name = "Contenido", columnDefinition = "TEXT")
    private String contenido;
    
    @Column(name = "DuracionMin")
    private Integer duracionMin;
    
    @ManyToOne
    @JoinColumn(name = "IdCurso", nullable = false)
    private Curso curso;
    
    // Constructor vacío
    public Leccion() {
    }
    
    // Constructor con parámetros
    public Leccion(Integer idLeccion, String titulo, String contenido, Integer duracionMin) {
        this.idLeccion = idLeccion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.duracionMin = duracionMin;
    }
    
    // Getters y Setters
    public Integer getIdLeccion() {
        return idLeccion;
    }
    
    public void setIdLeccion(Integer idLeccion) {
        this.idLeccion = idLeccion;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public Integer getDuracionMin() {
        return duracionMin;
    }
    
    public void setDuracionMin(Integer duracionMin) {
        this.duracionMin = duracionMin;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
