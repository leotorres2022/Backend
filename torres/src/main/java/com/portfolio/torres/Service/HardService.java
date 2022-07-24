
package com.portfolio.torres.Service;

import com.portfolio.torres.Entity.Hard;
import com.portfolio.torres.Repository.HardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class HardService {

    @Autowired
    HardRepository hardRepository;

    
    public List<Hard> list(){
        return hardRepository.findAll();
    }

    
    public Optional<Hard> getOne(int id){
        return hardRepository.findById(id);
    }

  

    public void  save(Hard hard){
       hardRepository.save(hard);
    }
    
    public void delete(int id){
        hardRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return hardRepository.existsById(id);
    }

   
}