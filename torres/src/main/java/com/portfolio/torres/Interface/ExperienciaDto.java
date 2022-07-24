
package com.portfolio.torres.Interface;

import javax.validation.constraints.NotBlank;

public class ExperienciaDto { @NotBlank
    private String empresa;
    @NotBlank
    private String actividad;

    public ExperienciaDto() {
    }

    public ExperienciaDto(@NotBlank String empresa,@NotBlank String actividad) {
        this.empresa = empresa;
        this.actividad = actividad;
      
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    
    
}




   
