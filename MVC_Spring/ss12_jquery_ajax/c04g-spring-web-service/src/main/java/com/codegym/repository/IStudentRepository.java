package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    // C1
    @Query(value = "select id, `name`, date_of_birth\n" +
            "from student\n" +
            "where `name` like :keyword", nativeQuery = true)
    List<Student> searchStudentWithName(@Param("keyword") String nameStudent);

    // C2
    Page<Student> findAllByNameContaining(String nameStudent, Pageable pageable);
}
