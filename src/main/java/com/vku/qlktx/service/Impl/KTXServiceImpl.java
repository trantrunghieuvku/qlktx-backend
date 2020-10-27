package com.vku.qlktx.service.Impl;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.repository.FeedbackRepository;
import com.vku.qlktx.repository.RegisterRepository;
import com.vku.qlktx.repository.RoomRepository;
import com.vku.qlktx.service.KTXService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KTXServiceImpl implements KTXService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private RoomRepository roomRepository;
    
    //vd,ok nhớ có autowire cái nào cũng thế// hoang mang ghê, để coi hiếu code
    //dễ hiểu mà,hơi rối ở đoạn implements,k cần interface cũng k sao nhưng mà k biêt  được có những hàm nào bên trong
    // haha ok có j hỏi hiếu, tắt nha ok
    @Autowired 
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Register> getAllRegister() {
        return registerRepository.findAll();
    }

    @Override
    public Optional<Register> getRegisterById(Integer id) {
        return registerRepository.findById(id);
    }

    // @Override
    // public List<Room> searchRoom(String rName) {
    //     return roomRepository.findByrNameStartingWith(rName);
    // }

    @Override
    public Room getRoomByName(String roomName) {
        return roomRepository.findByrNameStartingWith(roomName);
    }

    @Override
    public boolean addRegister(Register register) {
        registerRepository.save(register);
        return true;

    }

    

          
}
 