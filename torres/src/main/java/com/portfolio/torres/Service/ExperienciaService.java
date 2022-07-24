
package com.portfolio.torres.Service;
import com.portfolio.torres.Entity.Experiencia;
import com.portfolio.torres.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    
    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }

    
    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }

  

    public void  save(Experiencia experiencia){
        experienciaRepository.save(experiencia);
    }
    
    public void delete(int id){
        experienciaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }

   
}

