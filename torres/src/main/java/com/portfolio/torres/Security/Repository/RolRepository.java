
package com.portfolio.torres.Security.Repository;

import com.portfolio.torres.Security.Entity.Rol;
import com.portfolio.torres.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
 Optional<Rol> findByRolNombre  (RolNombre rolNombre);  
}
