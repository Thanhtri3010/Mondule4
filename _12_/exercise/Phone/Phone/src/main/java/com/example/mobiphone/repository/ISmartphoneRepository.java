package com.example.mobiphone.repository;

import com.example.mobiphone.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Integer> {

    List<Smartphone> findAllByModelContains(String name);
}
