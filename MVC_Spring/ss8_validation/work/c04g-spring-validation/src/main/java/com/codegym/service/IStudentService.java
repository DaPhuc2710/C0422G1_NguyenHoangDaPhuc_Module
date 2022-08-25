package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Student findById(Integer id);
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    void save(Student studentObj);
    Page<Student> findAllSearchAndPaging(String nameStudent, Pageable pageable);
}
