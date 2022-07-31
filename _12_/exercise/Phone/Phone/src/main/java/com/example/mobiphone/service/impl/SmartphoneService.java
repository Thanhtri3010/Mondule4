package com.example.mobiphone.service.impl;

import com.example.mobiphone.model.Smartphone;
import com.example.mobiphone.repository.ISmartphoneRepository;
import com.example.mobiphone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartPhoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartPhoneRepository.save(smartphone);
    }

    @Override
    public Optional<Smartphone> findById(int id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        smartPhoneRepository.deleteById(id);
    }
}