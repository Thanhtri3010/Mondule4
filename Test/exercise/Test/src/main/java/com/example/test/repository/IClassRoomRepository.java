package com.example.test.repository;

import com.example.test.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
