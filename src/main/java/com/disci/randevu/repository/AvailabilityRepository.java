package com.disci.randevu.repository;

import com.disci.randevu.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByDentistIdAndAvailabilityDate(Long dentistId, LocalDate availabilityDate);
}
