package com.vku.qlktx.repository;

import java.util.List;

import com.vku.qlktx.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    
    List<Room> findByrNameStartingWith(String rName);
}
