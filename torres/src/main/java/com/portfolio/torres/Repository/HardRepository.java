
package com.portfolio.torres.Repository;


import com.portfolio.torres.Entity.Hard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HardRepository extends JpaRepository<Hard, Integer>{
    
}