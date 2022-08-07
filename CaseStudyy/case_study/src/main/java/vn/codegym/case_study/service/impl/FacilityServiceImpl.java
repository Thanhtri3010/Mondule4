package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.Facility;
import vn.codegym.case_study.repository.FacilityRepository;
import vn.codegym.case_study.service.FacilityService;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    FacilityRepository facilityRepository;


    @Override
    public Page<Facility> findAll(Pageable pageable, String keyword) {
        return facilityRepository.findAll(pageable, "%" + keyword + "%");
    }

    @Override
    public List<Facility> getList() {
        return facilityRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Integer id) {
        facilityRepository.deleteById(id);
    }

}
