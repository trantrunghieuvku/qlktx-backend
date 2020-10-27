package com.vku.qlktx.payload.request;

import javax.validation.constraints.*;
import java.util.Date;

public class RegisterRequest {
    private String name;

    private String sCode;

    @Email
    private String email;

    private Long Identification;

    private Date dob;

    private String address;

    private String roomName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdentification() {
        return Identification;
    }

    public void setIdentification(Long identification) {
        Identification = identification;
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


}
