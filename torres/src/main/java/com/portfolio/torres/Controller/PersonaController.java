
package com.portfolio.torres.Controller;

import com.portfolio.torres.Entity.Persona;
import com.portfolio.torres.Interface.Mensaje;
import com.portfolio.torres.Interface.PersonaDto;
import com.portfolio.torres.Service.PersonaService;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "https://fronttorres-fe218.web.app/portfolio")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el registro"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
 
    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){    
        Persona persona = new Persona();
        persona.setNombre(personaDto.getNombre());
         persona.setApellido(personaDto.getApellido());
          persona.setTitulo(personaDto.getTitulo());
           persona.setInformacion(personaDto.getInformacion());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("la persona fue creada"), HttpStatus.OK);
    }
     
     
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PersonaDto personaDto){
        
        Persona persona = personaService.getOne(id).get();
       persona.setNombre(personaDto.getNombre());
         persona.setApellido(personaDto.getApellido());
          persona.setTitulo(personaDto.getTitulo());
           persona.setInformacion(personaDto.getInformacion());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Registro  Actualizado"), HttpStatus.OK);
    }
  
  
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }


}