package com.vku.qlktx.service;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.model.Students;

public interface KTXService {
    List<Register> getAllRegister();
    Register getRegisterById(Integer id);
    void addRegister(Register register);
    // List<Room> searchRoom(String rName);
    Room getRoomByName(String roomName);
    List<Room> getAllRoom();
    int getIdRoomByName(String roomName);
    void deleteRoomById(Integer id);

    List<Register> getAlRegisterByRoomId(int roomId);
    List<Students> getAllStudentByRoomId(int roomId);
    Register getRegisterByIdentification(Long identification);
    Integer countByIdentificationRegister(Long identification);
    boolean deleteRegisterById(Integer id);

    Students getStudentsByIdentification(Long identification);
    Integer countByIdentificationStudents(Long identification);
    
    

    

}
