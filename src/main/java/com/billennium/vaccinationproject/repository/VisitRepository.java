package com.billennium.vaccinationproject.repository;

import com.billennium.vaccinationproject.entity.VisitEntity;
import com.billennium.vaccinationproject.utilities.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

    Optional<VisitEntity> findByVisitDateAndVisitDateTime(LocalDate visitDate, LocalTime visitDateTime);

    Page<VisitEntity> findAllByVisitDate(LocalDate today,Pageable pageable);

    Page<VisitEntity> findByVisitDateBetweenAndFacilityCityLikeAndUserDetailsIsNull(LocalDate fromDate, LocalDate toDate, String city, Pageable pageable);

    Page<VisitEntity> findByVisitDateBetweenAndFacilityCityLikeAndVaccineManufacturerAndUserDetailsIsNull(LocalDate fromDate, LocalDate toDate, String city, Manufacturer manufacturer, Pageable pageable);
}
