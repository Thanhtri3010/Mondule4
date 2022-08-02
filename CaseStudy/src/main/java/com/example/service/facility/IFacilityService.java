package com.example.service.facility;

import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<FacilityType> findAllFacilityType();

    List<RentType> findAllRentType();

    Facility save(Facility facility);

    Optional<Facility> findFacilityById(int id);

    void deleteFacilityById(int id);

    Page<Facility> findAllFacility(Pageable pageable);

    Page<Facility> findAllFacilityByKeyword(String keyword, Pageable pageable);
}
