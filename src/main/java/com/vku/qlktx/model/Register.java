package com.vku.qlktx.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String sCode;
    private String email;
    private Long Identification;
    private Date dob;
    private String address;
    @ManyToOne(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="r_id")
    private Room roomRegisters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Room getRoomRegisters() {
        return roomRegisters;
    }

    public void setRoomRegisters(Room roomRegisters) {
        this.roomRegisters = roomRegisters;
    }

    
}
