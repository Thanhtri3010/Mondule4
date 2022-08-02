package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from facility where facility_name like :keyword", nativeQuery = true,
            countQuery = "select * from facility where facility_name like :keyword")
    Page<Facility> findAllFacilityByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
