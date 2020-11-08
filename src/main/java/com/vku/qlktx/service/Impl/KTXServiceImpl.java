package com.vku.qlktx.service.Impl;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.model.Students;
import com.vku.qlktx.repository.FeedbackRepository;
import com.vku.qlktx.repository.RegisterRepository;
import com.vku.qlktx.repository.RoomRepository;
import com.vku.qlktx.repository.StudentsRepository;
import com.vku.qlktx.service.KTXService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KTXServiceImpl implements KTXService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Register> getAllRegister() {
        return registerRepository.findAll();
    }

    @Override
    public Register getRegisterById(Integer id) {
        return registerRepository.findById(id).get();
    }

    // @Override
    // public List<Room> searchRoom(String rName) {
    // return roomRepository.findByrNameStartingWith(rName);
    // }

    @Override
    public Room getRoomByName(String roomName) {
        return roomRepository.findByNameStartingWith(roomName);
    }

    @Override
    public void addRegister(Register register) {
        registerRepository.save(register);
    }

    @Override
    public Register getRegisterByIdentification(Long identification) {
        return registerRepository.findByIdentification(identification);
    }

    @Override
    public Students getStudentsByIdentification(Long identification) {
        return studentsRepository.getStudentsByIdentification(identification);
    }

    @Override
    public Integer countByIdentificationStudents(Long identification) {
        return studentsRepository.countByIdentificationStudents(identification);
    }

    @Override
    public Integer countByIdentificationRegister(Long identification) {
        return registerRepository.countByIdentificationRegister(identification);
    }

    @Override
    public boolean deleteRegisterById(Integer id){
        registerRepository.deleteById(id);
        return true;
        
    }
    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public int getIdRoomByName(String roomName) {
        return roomRepository.getRoomByName(roomName).getId();
    }

    @Override
    public List<Register> getAlRegisterByRoomId(int roomId) {
        return registerRepository.getAllRegisterByRoomId(roomId);
    }

    @Override
    public List<Students> getAllStudentByRoomId(int roomId) {
        return studentsRepository.getAllStudentByRoomId(roomId);
    }

    @Override
    public void deleteRoomById(Integer id) {
        // TODO Auto-generated method stub
        roomRepository.deleteById(id);

    }
}
 