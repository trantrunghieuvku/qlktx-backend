package com.vku.qlktx.model;

import java.util.Date;


import javax.persistence.*;

@Entity
public class BillDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String type;

    @Column
    private Long unit;

    @Column
    private Date modifiedDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "billDetails")
    private Bill bill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        modifiedDate = modifiedDate;
    }
}
