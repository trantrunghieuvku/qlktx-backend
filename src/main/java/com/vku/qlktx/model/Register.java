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

    @Column(unique = true)
    private String sCode;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Column(unique = true)
    private Long Identification;

    @Column
    private Date dob;

    @Column
    private String address;
    
    @ManyToOne(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="r_id")
    private Room roomRegisters;


    public Register(String name, String sCode, String email, Long Identification, Date dob, String address, Room roomRegisters) {
        this.name = name;
        this.sCode = sCode;
        this.email = email;
        this.Identification = Identification;
        this.dob = dob;
        this.address = address;
        this.roomRegisters = roomRegisters;
    }


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
