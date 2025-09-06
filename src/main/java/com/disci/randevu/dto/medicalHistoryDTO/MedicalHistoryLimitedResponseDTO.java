package com.disci.randevu.dto.medicalHistoryDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalHistoryLimitedResponseDTO {
    private Long id;
    private LocalDate pastMedicalDate;
}
