package com.vku.qlktx.controller;

import java.util.*;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.service.Impl.KTXServiceImpl;
import com.vku.qlktx.payload.request.RegisterRequest;
import com.vku.qlktx.repository.RegisterRepository;
import com.vku.qlktx.repository.StudentsRepository;

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

    @PostMapping(value="/register")
    public String addRegister(@RequestBody RegisterRequest registerRequest ){
        String s = "222";
        Room    room    = ktxService.getRoomByName(registerRequest.getRoomName());
        String  name    =registerRequest.getName();
        String  code   =registerRequest.getCode();
        String  email   =registerRequest.getEmail();
        Long    identification=registerRequest.getIdentification();
        Date    dob     =registerRequest.getDob();
        String  address =registerRequest.getAddress();
        Register register = new Register(name, code, email, identification, dob, address, room); 
        
        //kiểm tra sự tồn tại trong bảng  Register và Students
        if(ktxService.countByIdentificationRegister(identification) == 0 && ktxService.countByIdentificationStudents(identification)==0){  
            ktxService.addRegister(register);
            s ="Đăng ký thành công";
        }
        else{
            if(ktxService.countByIdentificationRegister(identification) != 0){
                s= "Đã đăng ký";
            }
            if(ktxService.countByIdentificationStudents(identification) != 0){
                s= "Đã có phòng";
            }
        }
        return s;
    }

    @GetMapping("/register/") 
    public Register searchByIdentication(@RequestParam("cmnd") String cmnd){
        Long identification= Long.parseLong(cmnd);
        return ktxService.getRegisterByIdentification(identification);
    }
}
