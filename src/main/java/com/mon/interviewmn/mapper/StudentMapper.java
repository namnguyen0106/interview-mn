package com.mon.interviewmn.mapper;

import com.mon.interviewmn.dto.StudentDTO;
import com.mon.interviewmn.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {
}
