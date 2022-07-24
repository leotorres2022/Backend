
package com.portfolio.torres.Controller;

import com.portfolio.torres.Entity.Hard;
import com.portfolio.torres.Interface.HardDto;
import com.portfolio.torres.Interface.Mensaje;
import com.portfolio.torres.Service.HardService;
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
@RequestMapping("/hard")
@CrossOrigin(origins = "http://localhost:4200")
public class HardController {

    @Autowired
    HardService hardService;

    @GetMapping("/lista")
    public ResponseEntity<List<Hard>> list(){
        List<Hard> list = hardService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hard> getById(@PathVariable("id") int id){
        if(!hardService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el registro"), HttpStatus.NOT_FOUND);
        Hard hard = hardService.getOne(id).get();
        return new ResponseEntity(hard, HttpStatus.OK);
    }
 
    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody HardDto hardDto){    
       Hard hard = new Hard();
        hard.setNombre(hardDto.getNombre());
          hard.setPorcentaje((int) hardDto.getPorcentaje());
          hard.setImg(hardDto.getImg());
               hardService.save(hard);
        return new ResponseEntity(new Mensaje("Hard fue creado"), HttpStatus.OK);
    }
         
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody HardDto hardDto){
        
        Hard hard =hardService.getOne(id).get();
       hard.setNombre(hardDto.getNombre());
          hard.setPorcentaje((int) hardDto.getPorcentaje());
           hard.setImg(hardDto.getImg());
       hardService.save(hard);
        return new ResponseEntity(new Mensaje("Registro  Actualizado"), HttpStatus.OK);
    }
  
  
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!hardService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de hard"), HttpStatus.NOT_FOUND);
        hardService.delete(id);
        return new ResponseEntity(new Mensaje("hard eliminado"), HttpStatus.OK);
    }


}
