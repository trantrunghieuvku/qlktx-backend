package com.vku.qlktx.service;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.model.Students;

public interface KTXService {
    List<Register> getAllRegister();
    Optional<Register> getRegisterById(Integer id);
    void addRegister(Register register);
    // List<Room> searchRoom(String rName);
    Room getRoomByName(String roomName);
    Register getRegisterByIdentification(Long identification);
    Students getStudentsByIdentification(Long identification);
    Integer countByIdentificationStudents(Long identification);
    Integer countByIdentificationRegister(Long identification);

}
