
package com.portfolio.torres.Interface;

import javax.validation.constraints.NotBlank;

public class ProyectosDto {@NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;

    public ProyectosDto() {
    }

    public ProyectosDto(@NotBlank String nombre,@NotBlank String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
      
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
