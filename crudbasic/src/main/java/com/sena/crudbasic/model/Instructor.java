package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Instructores")
public class Instructor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInstructor")
    private Integer idInstructor;
    
    @Column(name = "IdUsuario", nullable = false)
    private Integer idUsuario;
    
    @Column(name = "Biografia", length = 500)
    private String biografia;
    
    // Constructor vacío
    public Instructor() {
    }
    
    // Constructor con parámetros
    public Instructor(Integer idInstructor, Integer idUsuario, String biografia) {
        this.idInstructor = idInstructor;
        this.idUsuario = idUsuario;
        this.biografia = biografia;
    }
    
    // Getters y Setters
    public Integer getIdInstructor() {
        return idInstructor;
    }
    
    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getBiografia() {
        return biografia;
    }
    
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}