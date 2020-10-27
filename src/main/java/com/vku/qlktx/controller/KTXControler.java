package com.vku.qlktx.controller;

import java.util.*;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.service.Impl.KTXServiceImpl;
import com.vku.qlktx.payload.request.RegisterRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KTXControler {
    
    @Autowired
    private KTXServiceImpl ktxService;

    @GetMapping(value="/register")
    public List<Register> getRegister() {
        return ktxService.getAllRegister();
    }

    @PostMapping(value="/register")
    public Register addRegister(@RequestBody RegisterRequest registerRequest ){
        Room    room    = ktxService.getRoomByName(registerRequest.getRoomName());
        String  name    =registerRequest.getName();
        String  sCode   =registerRequest.getsCode();
        String  email   =registerRequest.getEmail();
        Long    Identification=registerRequest.getIdentification();
        Date    dob     =registerRequest.getDob();
        String  address =registerRequest.getAddress();
        Register register = new Register(name, sCode, email, Identification, dob, address, room);
        
        ktxService.addRegister(register);
        return register;
    }

    // @GetMapping(value="/room")
    // public List<Room> getRoom(@RequestParam("name") String rName) {
    //     return ktxService.searchRoom("B203");
    // }


}
