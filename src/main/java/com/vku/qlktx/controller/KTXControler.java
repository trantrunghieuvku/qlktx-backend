package com.vku.qlktx.controller;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.service.Impl.KTXServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KTXControler {
    
    // mình có thể khai báo vô đây để gọi mà, sau này mình xử lí nhiều, 1 cái service mà đến 1000 dòng, nhìn chắc rối lắm
    //thế mới để 1 service. serivce mk cũng phải khai thêm repository cũng rối
    @Autowired
    private KTXServiceImpl ktxService;

    @GetMapping(value="/register")
    public List<Register> getRegister() {
        return ktxService.getAllRegister();
    }

    @GetMapping(value="/room")
    public List<Room> getRoom(@RequestParam("name") String rName) {
        return ktxService.searchRoom(rName);
    }
}
