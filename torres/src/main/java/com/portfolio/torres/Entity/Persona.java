
package com.portfolio.torres.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
  
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String nombre;
     
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String apellido;
     
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String titulo;
     
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String informacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
