package com.vku.qlktx.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Bill{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int type;

    @Column
    private Date month;

    @Column
    private int hIndex;;

    @Column
    private int fIndex;

    @Column
    private boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "r_id", referencedColumnName = "id")
    private Room roomBill;

    @OneToOne(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="b_id")
    private BillDetails billDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public int gethIndex() {
        return hIndex;
    }

    public void sethIndex(int hIndex) {
        this.hIndex = hIndex;
    }

    public int getfIndex() {
        return fIndex;
    }

    public void setfIndex(int fIndex) {
        this.fIndex = fIndex;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Room getRoomBill() {
        return roomBill;
    }

    public void setRoomBill(Room roomBill) {
        this.roomBill = roomBill;
    }

    public BillDetails getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(BillDetails billDetails) {
        this.billDetails = billDetails;
    }

    
}
