package com.vku.qlktx.service.Impl;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Room;
import com.vku.qlktx.repository.RoomRepository;
import com.vku.qlktx.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // @Override
    // public Room getRoomByName(String name) {
    //     // return roomRepository.getRoomByName(name);
    // }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void remove(Room room) {
        roomRepository.delete(room);
    }
    
}
