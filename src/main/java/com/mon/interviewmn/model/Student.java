package com.mon.interviewmn.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "students")
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String address;
    private Date dateOfBirth;
    private String phone;
    private String occupation;
    private String level;
    private String expect;
    private int iqTest;
    private int isPass;
    private Date interviewDay;
}
