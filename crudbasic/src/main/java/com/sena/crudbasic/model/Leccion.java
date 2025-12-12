package com.sena.crudbasic.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.model.base.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Lecciones")
public class Leccion extends BaseModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLeccion")
    @JsonView(Views.Basic.class)
    private Integer idLeccion;
    
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 150, message = "El título no puede exceder 150 caracteres")
    @Column(name = "Titulo", length = 150)
    @JsonView(Views.Basic.class)
    private String titulo;
    
    @Column(name = "Contenido", columnDefinition = "TEXT")
    @JsonView(Views.Basic.class)
    private String contenido;
    
    @Min(value = 1, message = "La duración debe ser al menos 1 minuto")
    @Column(name = "DuracionMin")
    @JsonView(Views.Basic.class)
    private Integer duracionMin;
    
    @NotNull(message = "El curso es obligatorio")
    @ManyToOne
    @JoinColumn(name = "IdCurso", nullable = false)
    @JsonView(Views.Detailed.class)
    private Curso curso;
    
    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }
    
    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
    }
}