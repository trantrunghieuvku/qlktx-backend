package com.vku.qlktx.service.Impl;
import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
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
    public void addRegister(Register register) {
        registerRepository.save(register);

    }

          
}
 