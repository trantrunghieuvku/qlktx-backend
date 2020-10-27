package com.vku.qlktx.repository;

import java.util.Optional;

import com.vku.qlktx.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer> {
    
}
