package com.portfolio.torres.Controller;

import com.portfolio.torres.Entity.Proyectos;
import com.portfolio.torres.Interface.Mensaje;
import com.portfolio.torres.Interface.ProyectosDto;
import com.portfolio.torres.Service.ProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://fronttorres-fe218.web.app/portfolio")
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
 
    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody ProyectosDto proyectosDto){    
        Proyectos proyectos = new Proyectos();
        proyectos.setNombre(proyectosDto.getNombre());
          proyectos.setDescripcion(proyectosDto.getDescripcion());
               proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("El proyecto fue creado"), HttpStatus.OK);
    }
         
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectosDto proyectosDto){
        
        Proyectos proyectos = proyectosService.getOne(id).get();
       proyectos.setNombre(proyectosDto.getNombre());
          proyectos.setDescripcion(proyectosDto.getDescripcion());
       proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Registro  Actualizado"), HttpStatus.OK);
    }
  
  
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro "), HttpStatus.NOT_FOUND);
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }


}