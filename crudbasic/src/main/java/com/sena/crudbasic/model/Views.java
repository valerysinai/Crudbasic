package com.sena.crudbasic.model;

public class Views {
    
    // Vista básica - solo datos simples
    public static class Basic {}
    
    // Vista detallada - incluye relaciones
    public static class Detailed extends Basic {}
    
    // Vista para crear/actualizar - sin IDs generados
    public static class CreateUpdate {}
}

🔄 PASO 5: ACTUALIZAR LOS MODELOS CON LOMBOK Y JSONVIEW
1. Instructor.java - REEMPLAZAR TODO
Ruta: src/main/java/com/sena/crudbasic/model/Instructor.java
javapackage com.sena.crudbasic.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.model.base.BaseModel;
import jakarta.persistence.*;
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
@Table(name = "Instructores")
public class Instructor extends BaseModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInstructor")
    @JsonView(Views.Basic.class)
    private Integer idInstructor;
    
    @NotNull(message = "El ID de usuario es obligatorio")
    @Column(name = "IdUsuario", nullable = false)
    @JsonView(Views.Basic.class)
    private Integer idUsuario;
    
    @Size(max = 500, message = "La biografía no puede exceder 500 caracteres")
    @Column(name = "Biografia", length = 500)
    @JsonView(Views.Basic.class)
    private String biografia;
    
    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }
    
    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
    }
}
