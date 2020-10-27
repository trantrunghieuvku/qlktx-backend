package com.vku.qlktx.controller;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.service.Impl.RegisterServiceImpl;
import com.vku.qlktx.service.Impl.RoomServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class RegisterControler {
    
    @Autowired
    private RegisterServiceImpl registerServiceImpl;
    // @Autowired
    // private RoomServiceImpl roomServiceImpl;

    
    @GetMapping(value="/register")
    public List<Register> getRegister() {
        return registerServiceImpl.getAllRegister();
    }
    
    @PostMapping(value="/register")
    public Register addRegister(@RequestBody Register register) {
         registerServiceImpl.save(register);
        // return RoomServiceImpl.getRoomByName("A101");
        return register;
    }
    // @PostMapping(value="/test")
    // public Room test(@RequestBody Register register) {
    //     return roomServiceImpl.getRoomByName("BA01"); 
    // }
}
