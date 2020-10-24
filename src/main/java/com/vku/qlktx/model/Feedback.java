package com.vku.qlktx.model;

import javax.persistence.*;

@Entity
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne(targetEntity = Students.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="s_id")
    private Students feedbackStudents;


}
