package com.vku.qlktx.repository;

import com.vku.qlktx.model.Register;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Integer> {
    
}
