package com.vku.qlktx.repository;

import com.vku.qlktx.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentsRepository extends JpaRepository<Students,Integer> {
	Students getStudentsByIdentification(Long identification);
	
	@Query("select count(s) from Students s where s.identification = ?1")
    int countByIdentificationStudents(Long identification);  
}
