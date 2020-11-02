package com.vku.qlktx.controller;

import java.util.*;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.service.Impl.KTXServiceImpl;
import com.vku.qlktx.payload.request.RegisterRequest;
import com.vku.qlktx.repository.RegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KTXControler {
    
    // mình có thể khai báo vô đây để gọi mà, sau này mình xử lí nhiều, 1 cái service mà đến 1000 dòng, nhìn chắc rối lắm
    //thế mới để 1 service. serivce mk cũng phải khai thêm repository cũng rối
    @Autowired
    private KTXServiceImpl ktxService; 
    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping(value="/register/")
    public String addRegister(@RequestBody RegisterRequest registerRequest ){
        String s = "";
        Room    room    = ktxService.getRoomByName(registerRequest.getRoomName());
        String  name    =registerRequest.getName();
        String  code   =registerRequest.getCode();
        String  email   =registerRequest.getEmail();
        Long    identification=registerRequest.getIdentification();
        Date    dob     =registerRequest.getDob();
        String  address =registerRequest.getAddress();
        Register register = new Register(name, code, email, identification, dob, address, room); 
        ktxService.addRegister(register);
        
        //kiểm tra sự tồn tại trong bảng  Register
        if(ktxService.getRegisterByIdentification(identification).equals("") == false){
            s ="Bạn đã đăng ký.";
            
        }
        else{
            s = "Đăng ký thành công";
        
        }
        return s;
    }

    // @GetMapping(value="/room")
    // public List<Room> getRoom(@RequestParam("name") String rName) {
    //     return ktxService.searchRoom("B203");
    // }

    @GetMapping("/register/") 
    public Register searchByIdentication(@RequestParam("cmnd") String cmnd){
        Long identification= Long.parseLong(cmnd);
        return ktxService.getRegisterByIdentification(identification);
    }
}
