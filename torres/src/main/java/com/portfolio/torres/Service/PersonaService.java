
package com.portfolio.torres.Service;

import com.portfolio.torres.Entity.Persona;
import com.portfolio.torres.Repository.PersonaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    
    public List<Persona> list(){
        return personaRepository.findAll();
    }

    
    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }

  

    public void  save(Persona persona){
        personaRepository.save(persona);
    }
    
    public void delete(int id){
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }

   
}

