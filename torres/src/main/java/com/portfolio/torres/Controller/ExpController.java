
package com.portfolio.torres.Controller;
import com.portfolio.torres.Entity.Experiencia;
import com.portfolio.torres.Interface.ExperienciaDto;
import com.portfolio.torres.Interface.Mensaje;
import com.portfolio.torres.Service.ExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://fronttorres-fe218.web.app/portfolio")
public class ExpController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
 
    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto){    
        Experiencia experiencia = new Experiencia();
        experiencia.setEmpresa(experienciaDto.getEmpresa());
          experiencia.setActividad(experienciaDto.getActividad());
               experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("El producto fue creado"), HttpStatus.OK);
    }
         
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ExperienciaDto experienciaDto){
        
        Experiencia experiencia = experienciaService.getOne(id).get();
       experiencia.setEmpresa(experienciaDto.getEmpresa());
          experiencia.setActividad(experienciaDto.getActividad());
       experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Registro de Educacion Actualizado"), HttpStatus.OK);
    }
  
  
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de experiencia"), HttpStatus.NOT_FOUND);
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminado"), HttpStatus.OK);
    }


}
