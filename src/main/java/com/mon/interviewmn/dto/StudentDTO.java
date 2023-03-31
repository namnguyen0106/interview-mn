package com.mon.interviewmn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends BaseDTO {
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
