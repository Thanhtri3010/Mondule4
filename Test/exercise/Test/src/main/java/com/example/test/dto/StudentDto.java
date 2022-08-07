package com.example.test.dto;

import com.example.test.model.ClassRoom;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class StudentDto {

    private int studentId;

    @Pattern(message = "*Không đúng định dạng (VD: Lê Văn An)", regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$")
    private String studentName;

    @NotBlank(message = "Không được để trống")
    private String studentAge;

    @NotNull(message = "Không được để trống")
    private int studentGender;

    @NotNull(message = "*Không được để trống!")
    private ClassRoom classRoom;

    public StudentDto() {
    }

    public StudentDto(int studentId, String studentName, String studentAge, int studentGender, ClassRoom classRoom) {
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
