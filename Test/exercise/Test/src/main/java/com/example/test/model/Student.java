package com.example.test.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentAge;
    private int studentGender;

    @ManyToOne
    @JoinColumn(name = "classRoomId", referencedColumnName = "classRoomId")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentAge, int studentGender, ClassRoom classRoom) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.classRoom = classRoom;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public int getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(int studentGender) {
        this.studentGender = studentGender;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
