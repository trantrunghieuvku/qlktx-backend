package com.vku.qlktx.repository;

import com.vku.qlktx.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Integer> {
    
}
