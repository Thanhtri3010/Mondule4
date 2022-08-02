package com.example.service.facility.impl;

import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.repository.facility.IFacilityRepository;
import com.example.repository.facility.IFacilityTypeRepository;
import com.example.repository.facility.IRentTypeRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Autowired
    private IRentTypeRepository rentTypeRepository;


    @Override
    public List<FacilityType> findAllFacilityType() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findFacilityById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void deleteFacilityById(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findAllFacility(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Page<Facility> findAllFacilityByKeyword(String keyword, Pageable pageable) {
        return facilityRepository.findAllFacilityByKeyword("%" + keyword + "%", pageable);
    }
}
