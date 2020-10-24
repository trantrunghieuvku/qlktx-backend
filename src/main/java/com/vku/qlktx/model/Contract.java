package com.vku.qlktx.model;

import javax.persistence.*;

@Entity
public class Contract {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "s_id", referencedColumnName = "id")
    private Students contractStudents;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_id", referencedColumnName = "id")
    private Employees contractEmployees;
}
