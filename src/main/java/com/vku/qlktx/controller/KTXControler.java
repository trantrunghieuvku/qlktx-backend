package com.vku.qlktx.controller;

import java.util.*;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.model.Students;
import com.vku.qlktx.service.KTXService;
import com.vku.qlktx.service.Impl.KTXServiceImpl;
import com.vku.qlktx.payload.request.RegisterRequest;
import com.vku.qlktx.repository.RoomRepository;
import com.vku.qlktx.repository.StudentsRepository;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KTXControler {
    
    // mình có thể khai báo vô đây để gọi mà, sau này mình xử lí nhiều, 1 cái service mà đến 1000 dòng, nhìn chắc rối lắm
    //thế mới để 1 service. serivce mk cũng phải khai thêm repository cũng rối
   
    @Autowired
    private KTXServiceImpl ktxService;
    
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping(value="/register")
    public String addRegister(@RequestBody RegisterRequest registerRequest){
        String s = "";
        Room    room    = ktxService.getRoomByName(registerRequest.getRoomName());
        String  name    =registerRequest.getName();
        String  code   =registerRequest.getCode();
        String  email   =registerRequest.getEmail();
        Long    identification=registerRequest.getIdentification();
        Date    dob     =registerRequest.getDob();
        String  address =registerRequest.getAddress();
        String classroom =registerRequest.getClassroom();
        Long phone =registerRequest.getPhone();
        Register register = new Register(name, code, email, identification, dob,classroom,address,phone, room); 

        int students = ktxService.countByIdentificationStudents(identification);
        int registers = ktxService.countByIdentificationRegister(identification);
        
        //kiểm tra sự tồn tại trong bảng  Register và Students
        if (ktxService.checkCurrentRoom(registerRequest.getRoomName())){
        if( registers == 0 &&  students == 0){  
            ktxService.addRegister(register);
            s ="Đăng ký thành công";
        }
        else{
            if(registers != 0){
                s= "Đã đăng ký";
            }
            if(students != 0){
                s= "Đã có phòng";
            }
        }
    }
    else s="Phòng đã đủ";
    return s;
    }

    // @GetMapping("/register/") 
    // public Register searchByIdentication(@RequestParam("cmnd") String cmnd){
    //     Long identification= Long.parseLong(cmnd);
    //     return ktxService.getRegisterByIdentification(identification);
    // }

    @GetMapping(value="/listroom")
    public List<Room> getAllRoom() {
        return ktxService.getAllRoom();
    }

    @GetMapping("/room/register") 
    public List<Register> getRegisterByRoomName(@RequestParam("name") String roomName){
        int idRoom= ktxService.getIdRoomByName(roomName);
        return ktxService.getAlRegisterByRoomId(idRoom);
    }

    @GetMapping("register/acception/{id}")
    public String  deleteRegister(@PathVariable("id")Integer id){
        Register register = ktxService.getRegisterById(id);
        Room room =register.getRoomRegisters();

        if(ktxService.checkCurrentRoom(room.getName()))
        {
        Students students = new Students();
        students.setName(register.getName());
        students.setAddress(register.getAddress());
        students.setClassroom(register.getClassroom());
        students.setCode(register.getCode());
        students.setDob(register.getDob());
        students.setIdentification(register.getIdentification());
        students.setEmail(register.getEmail());
        students.setPhone(register.getPhone());
        students.setRoomStudents(register.getRoomRegisters());
        studentsRepository.save(students);

        room.setCurrent(room.getCurrent()+1);
        roomRepository.save(room);
        
        ktxService.deleteRegisterById(id);
        return "Thành công";
        }
        else{
            return "Thất Bại";
        }

    }

    @GetMapping("/room/students/") 
    public List<Students> getStudentByRoomName(@RequestParam("name") String roomName){
        int idRoom= ktxService.getIdRoomByName(roomName);
        return ktxService.getAllStudentByRoomId(idRoom);
    }

    @GetMapping("/register/") 
    public Register searchByIdentication(@RequestParam("cmnd") String cmnd){
        Long identification= Long.parseLong(cmnd);
        return ktxService.getRegisterByIdentification(identification);
    }

    @DeleteMapping("/room/delete/{id}")
    public void deleteRoom(@PathVariable("id") Integer id){
        ktxService.deleteRoomById(id);
    }

    @PutMapping("/room/edit")
    public String editRoom(@RequestBody Room room){
        Room r = new Room();
        r.setId(room.getId());
        r.setName(room.getName());
        r.setQuality(room.getQuality());
        r.setMax(room.getMax());
        r.setStatus(room.getStatus());
        roomRepository.save(r);
        return "Thành công";
    }
}
