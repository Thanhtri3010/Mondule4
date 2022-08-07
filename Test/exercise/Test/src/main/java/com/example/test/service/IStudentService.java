package com.example.test.service;

import com.example.test.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStudentService {

    Student save(Student student);

    Optional<Student> findStudentById(int id);

    void deleteStudentById(int id);

    Page<Student> findAllStudent(Pageable pageable);

    Page<Student> findAllStudentByKeyword(Pageable pageable, String name);
}
