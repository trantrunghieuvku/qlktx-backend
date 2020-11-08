package com.vku.qlktx.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Column
    private String name;

    @Column
    private String code;

    @Email
    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    private Long identification;

    @Column
    private Date dob;
    @Column
    private String classroom;

    @Column
    private String address;

    @Column 
    private Long phone;
    
    @ManyToOne(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="r_id")
    private Room roomRegisters;

    public Register() {
    }


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

    public Room getRoomRegisters() {
        return roomRegisters;
    }

    public void setRoomRegisters(Room roomRegisters) {
        this.roomRegisters = roomRegisters;
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

    public Register( @NotNull @NotBlank String name, String code, @Email @NotNull String email,
            @NotNull Long identification, Date dob, String classroom, String address, Long phone, Room roomRegisters) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.identification = identification;
        this.dob = dob;
        this.classroom = classroom;
        this.address = address;
        this.phone = phone;
        this.roomRegisters = roomRegisters;
    }


    

    
}
