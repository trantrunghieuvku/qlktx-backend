package com.vku.qlktx.service;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;

public interface KTXService {
    List<Register> getAllRegister();
    Optional<Register> getRegisterById(Integer id);
    void addRegister(Register register);
    // List<Room> searchRoom(String rName);
    Room getRoomByName(String roomName);

   
}
