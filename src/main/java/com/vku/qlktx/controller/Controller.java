package com.vku.qlktx.controller;

import java.util.List;
import com.vku.qlktx.model.Register;
import com.vku.qlktx.service.Impl.KTXServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KTXServiceImpl ktxService;
    
    @GetMapping(value="/register")
    public List<Register> getRegister() {
        return ktxService.getAllRegister();
    }
}
