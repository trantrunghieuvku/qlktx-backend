package com.vku.qlktx.repository;

import com.vku.qlktx.model.Contract;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    
}
