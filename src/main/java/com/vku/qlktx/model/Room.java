package com.vku.qlktx.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String status;
    
    @Column
    private String Quality;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomRegisters")
    private Set<Register> listRegisters = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomStudents")
    private Set<Students> listStudents = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomBill")
    private Set<Bill> listBill = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getrName() {
        return name;
    }

    public void setrName(String rName) {
        this.name = rName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    
}
