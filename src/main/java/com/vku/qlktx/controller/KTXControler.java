package com.vku.qlktx.controller;

import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.repository.RegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KTXControler {
    
    @Autowired
    private RegisterRepository registerRepository;

    @GetMapping(value="/register")
    public Optional<Register> getRegister(@PathVariable("id") Integer id) {
        return  registerRepository.findById(id);
    }
    
}
