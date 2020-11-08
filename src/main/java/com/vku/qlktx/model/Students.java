package com.vku.qlktx.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Students {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String classroom;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private Long identification;

    @Column
    private Date dob;

    @Column
    private Long phone;

    @ManyToOne(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="r_id")
    private Room roomStudents;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "u_id", referencedColumnName = "id")
    private User studentUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "feedbackStudents")
    private Set<Feedback> listBill = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contractStudents")
    private Contract contract;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Room getRoomStudents() {
        return roomStudents;
    }

    public void setRoomStudents(Room roomStudents) {
        this.roomStudents = roomStudents;
    }
    
}
