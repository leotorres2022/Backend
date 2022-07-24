
package com.portfolio.torres.Interface;

import javax.validation.constraints.NotBlank;

public class PersonaDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String titulo;
    @NotBlank
    private String informacion;

    public PersonaDto() {
    }

    public PersonaDto(@NotBlank String nombre,@NotBlank String apellido, @NotBlank String titulo,@NotBlank String informacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo= titulo;
        this.informacion = informacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
}
