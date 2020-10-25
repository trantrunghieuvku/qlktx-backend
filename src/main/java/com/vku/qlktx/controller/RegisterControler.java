package com.vku.qlktx.controller;

import java.lang.StackWalker.Option;
import java.util.List;


import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Students;
import com.vku.qlktx.service.Impl.RegisterServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class RegisterControler {
    
    @Autowired
    private RegisterServiceImpl registerServiceImpl;

    
    @GetMapping(value="/register")
    public List<Register> getRegister() {
        return registerServiceImpl.getAllRegister();
    }
    
    @PostMapping(value="/register")
    public Register addRegister(@RequestBody Register register) {
        registerServiceImpl.save(register);
        return register;
    }
}
