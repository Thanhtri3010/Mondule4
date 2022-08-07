package com.example.test.service.impl;

import com.example.test.model.ClassRoom;
import com.example.test.repository.IClassRoomRepository;
import com.example.test.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    private IClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> findAllClassRoom() {
        return classRoomRepository.findAll();
    }
}
