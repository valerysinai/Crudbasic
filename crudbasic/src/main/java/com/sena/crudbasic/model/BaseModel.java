package com.sena.crudbasic.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseModel {
    
    @Column(name = "FechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;
    
    @Column(name = "FechaModificacion")
    private LocalDateTime fechaModificacion;
    
    @Column(name = "Estado")
    private Boolean estado = true;
    
    // Este método se ejecuta antes de crear el registro
    public void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = true;
        }
    }
    
    // Este método se ejecuta antes de actualizar el registro
    public void onUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }
}