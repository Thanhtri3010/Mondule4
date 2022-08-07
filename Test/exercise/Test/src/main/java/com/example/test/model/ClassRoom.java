package com.example.test.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classRoomId;
    private String classRoomName;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private Set<Student> studentSet;

    public ClassRoom() {
    }

    public ClassRoom(int classRoomId, String classRoomName, Set<Student> studentSet) {
        this.classRoomId = classRoomId;
        this.classRoomName = classRoomName;
        this.studentSet = studentSet;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
