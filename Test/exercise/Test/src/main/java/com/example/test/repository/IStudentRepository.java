package com.example.test.repository;

import com.example.test.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where student_name like :name",
            nativeQuery = true,
            countQuery = "select * from student where student_name like :name")
    Page<Student> findAllStudentByKeyword(Pageable pageable, @Param("name") String name);
}
