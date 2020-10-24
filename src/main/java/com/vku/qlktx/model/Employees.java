package com.vku.qlktx.model;

import javax.persistence.*;

@Entity
public class Employees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String eName;

    @Column
    private String Address;

    @Column
    private Long phone;
    
    @Column
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "u_id", referencedColumnName = "id")
    private User employeeUser;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contractEmployees")
    private Contract contract;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getEmployeeUser() {
        return employeeUser;
    }

    public void setEmployeeUser(User employeeUser) {
        this.employeeUser = employeeUser;
    }

    
}
