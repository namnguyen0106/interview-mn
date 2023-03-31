package com.mon.interviewmn.repository;

import com.mon.interviewmn.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends BaseRepository<Student>, JpaRepository<Student, Long> {
    @Query(value = "SELECT s FROM Student s " +
            "WHERE s.isPass = 0 " +
            "AND s.name = :name " +
            "AND s.dateOfBirth = :dateOfBirth " +
            "AND :checkDate < s.interviewDay")
    List<Student> checkSixMonthAgoStudent(@Param("name") String name,
                                    @Param("dateOfBirth") Date dateOfBirth,
                                    @Param("checkDate") Date checkDate);

    @Query(value = "SELECT s FROM Student s " +
            "WHERE (s.name IS NULL OR s.name LIKE %:name%) " +
            "AND (s.interviewDay IS NULL " +
            "   OR (s.interviewDay > :startDate AND s.interviewDay < :endDate))")
    List<Student> getStudents(@Param("name") String name,
                              @Param("startDate") Date startDate,
                              @Param("endDate") Date endDate);
}
