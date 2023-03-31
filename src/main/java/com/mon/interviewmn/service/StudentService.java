package com.mon.interviewmn.service;

import com.mon.interviewmn.dto.StudentDTO;
import com.mon.interviewmn.mapper.StudentMapper;
import com.mon.interviewmn.model.Student;
import com.mon.interviewmn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService extends BaseService<StudentRepository, StudentDTO, Student> {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentMapper mapper;

    @Override
    public StudentDTO create(StudentDTO dto) {
        Date sixMonthAgo = Date.from(Instant.from(LocalDate.now().minusMonths(6)));
        List<Student> checkExist = repository.checkSixMonthAgoStudent(dto.getName(),
                dto.getDateOfBirth(),
                sixMonthAgo);
        if (checkExist.size() > 0) {
            //TODO
            System.out.println("409");
        }
        Student student = mapper.toEntity(dto);
        repository.save(student);
        return dto;
    }

    @Override
    public StudentDTO update(StudentDTO dto) {
        Student student = new Student();
        mapper.updateFromDTO(dto, student);
        repository.save(student);
        return dto;
    }

    @Override
    public Optional<StudentDTO> getDetails(Long id) {
        return Optional.ofNullable(mapper.toDto(repository.findById(id).get()));
    }

    @Override
    public StudentDTO delete(StudentDTO dto) {
        return null;
    }

    @Override
    public List<StudentDTO> findAll(Map<String, String> param) throws ParseException {
        String name = param.get("name");
        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(param.get("startDate"));
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(param.get("endDate"));
        return mapper.toDto(repository.getStudents(name, startDate, endDate));
    }
}
