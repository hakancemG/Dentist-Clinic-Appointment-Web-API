package com.disci.randevu.dto.availabilityDTO;

import com.disci.randevu.dto.dentistDTO.DentistLimitedResponseDTO;
import com.disci.randevu.enums.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailabilityFullResponseDTO {
    private Long id;
    private LocalDate availabilityDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private AvailabilityStatus availabilityStatus;
    private DentistLimitedResponseDTO dentist;
}
