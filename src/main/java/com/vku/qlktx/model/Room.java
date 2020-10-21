package com.vku.qlktx.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Room {
    
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String rName;

    @Column
    private String status;
    
    @Column
    private String Quality;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomRegisters")
    private Set<Register> listRegisters = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
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
