package com.example.mobiphone.service;

import com.example.mobiphone.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Smartphone save(Smartphone smartphone);

    Optional<Smartphone> findById(int id);

    void remove(int id);
}
