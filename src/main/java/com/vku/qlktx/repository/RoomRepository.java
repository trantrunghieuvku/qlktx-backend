package com.vku.qlktx.repository;

import com.vku.qlktx.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer>{
    @Query("SELECT * FROM qlktx.room WHERE r_name = ?1")
    Room getRoomByName(String name);
}
