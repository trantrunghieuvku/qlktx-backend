package com.vku.qlktx.controller;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.repository.RegisterRepository;
import com.vku.qlktx.service.Impl.KTXServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KTXControler {
    
    @Autowired
    private KTXServiceImpl ktxService;

    @Autowired
    private RegisterRepository repository;

    @GetMapping(value="/register")
    public List<Register> getRegister() {
        return repository.findAll();
    }

    
    
}
