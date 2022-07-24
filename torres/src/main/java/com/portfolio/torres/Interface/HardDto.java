
package com.portfolio.torres.Interface;

import javax.validation.constraints.NotBlank;


public class HardDto { @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
            @NotBlank
    private String img;

    public HardDto () {
    }

    public HardDto (@NotBlank String nombre,@NotBlank int porcentaje,@NotBlank String img) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img=img;
      
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Number getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Number porcentaje) {
        this.porcentaje = (int) porcentaje;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}