
package com.portfolio.torres.Security.Service;

import com.portfolio.torres.Security.Entity.Rol;
import com.portfolio.torres.Security.Enums.RolNombre;
import com.portfolio.torres.Security.Repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
 @Autowired   
RolRepository rolRepository;
 public Optional<Rol> getByRolNombre(RolNombre rolNombre)
 {return rolRepository.findByRolNombre(rolNombre);}
 
 public void save(Rol rol)
 {rolRepository.save(rol);}
 }
