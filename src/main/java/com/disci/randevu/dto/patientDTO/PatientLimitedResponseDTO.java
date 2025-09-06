package com.disci.randevu.dto.patientDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientLimitedResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
}
