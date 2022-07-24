package com.portfolio.torres.Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
  
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String centro;
     
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String titulo;
     
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String anio_ingreso;
     
    @NotNull
    @Size(min=1, max=50, message = "No cumple con la longitud")
    private String anio_egreso;

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio_ingreso() {
        return anio_ingreso;
    }

    public void setAnio_ingreso(String anio_ingreso) {
        this.anio_ingreso = anio_ingreso;
    }

    public String getAnio_egreso() {
        return anio_egreso;
    }

    public void setAnio_egreso(String anio_egreso) {
        this.anio_egreso = anio_egreso;
    }
    
    
    
}

