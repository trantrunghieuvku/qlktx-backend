package com.vku.qlktx.payload.request;

import javax.validation.constraints.*;
import java.util.Date;

public class RegisterRequest {
    private String name;

    private String code;

    @Email
    private String email;

    private Long identification;

    private Date dob;

    private String address;

    private String roomName;

    private String classroom;
    private Long phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoomName(){
        return roomName;
    }

    public void setRoomName(String roomName){
        this.roomName=roomName;
    }

    public RegisterRequest(String name, String code, @Email String email, Long identification, Date dob, String address,
            String roomName, String classroom, Long phone) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.identification = identification;
        this.dob = dob;
        this.address = address;
        this.roomName = roomName;
        this.classroom = classroom;
        this.phone = phone;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }


}
