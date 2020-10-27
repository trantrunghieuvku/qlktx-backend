package com.vku.qlktx.repository;

import com.vku.qlktx.model.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    
}
