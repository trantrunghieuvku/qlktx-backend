package com.vku.qlktx.repository;

import com.vku.qlktx.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer> {
    Register findByIdentification(Long identification);


    @Query("select count(r) from Register r where r.identification = ?1")
    int countByIdentificationRegister(Long identification);
    
    
}
