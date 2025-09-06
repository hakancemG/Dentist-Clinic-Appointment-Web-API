package com.disci.randevu.service.availabilityService;

import com.disci.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityService {
    AvailabilityFullResponseDTO createAvailability(AvailabilityCreateDTO createDTO);

    AvailabilityFullResponseDTO updateAvailability(AvailabilityUpdateDTO updateDTO);

    AvailabilityFullResponseDTO getAvailabilityById(Long id);

    List<AvailabilityFullResponseDTO> findByDentistIdAndAvailabilityDate(Long dentistId, LocalDate availabilityDate);

    void deleteAvailability(Long id);
}
