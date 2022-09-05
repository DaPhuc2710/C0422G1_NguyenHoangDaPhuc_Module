package com.codegym.controller;

import com.codegym.dto.StudentDto;
import com.codegym.model.ClassCG;
import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/studentRestMomo")
public class StudentRestController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Student>> goStudentList(
                                @PageableDefault(size = 5) Pageable pageable) {

        Page<Student> studentPage = this.iStudentService.findAll(pageable);

        if (!studentPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(studentPage, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createStudent(@RequestBody StudentDto studentDto) {

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);

        ClassCG classCG = new ClassCG();
        classCG.setId(studentDto.getClassCG().getId());
        student.setClassCG(classCG);

        this.iStudentService.save(student);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
