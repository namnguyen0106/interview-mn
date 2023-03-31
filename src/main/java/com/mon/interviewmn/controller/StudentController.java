package com.mon.interviewmn.controller;

import com.mon.interviewmn.dto.StudentDTO;
import com.mon.interviewmn.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<StudentService, StudentDTO> {
}
