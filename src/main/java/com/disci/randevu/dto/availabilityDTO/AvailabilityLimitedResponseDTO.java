package com.disci.randevu.dto.availabilityDTO;

import com.disci.randevu.enums.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailabilityLimitedResponseDTO {
    private Long id;
    private LocalDate availabilityDate;
    private AvailabilityStatus availabilityStatus;
}
