package com.vku.qlktx.service;
import java.util.List;

import com.vku.qlktx.model.*;



public interface RoomService {
    List<Room> getAllRooms();
    // Room getRoomByName(String name);
    void save(Room room);
    void remove(Room room);
}
