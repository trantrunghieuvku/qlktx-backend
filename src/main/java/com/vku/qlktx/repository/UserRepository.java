package com.vku.qlktx.repository;

import com.vku.qlktx.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    
}
