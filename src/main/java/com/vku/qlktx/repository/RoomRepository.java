package com.vku.qlktx.repository;

import com.vku.qlktx.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    
    // List<Room> findByrNameStartingWith(String rName);
    Room findByNameStartingWith(String roomName);

    @Query(value = "select r.id from Room r where r.name = ?1", nativeQuery = true)
    int getIdRoomByName(String roomName);

    @Query(value = "SELECT COUNT(r.id) FROM Room r WHERE r.name=?1 AND r.current<r.max",nativeQuery = true)
    int getCountCurrentRoom(String roomName);
}
