package com.disci.randevu.dto.medicalHistoryDTO;

import com.disci.randevu.dto.dentistDTO.DentistLimitedResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalHistoryFullResponseDTO {
    private Long id;
    private PatientLimitedResponseDTO patient;
    private DentistLimitedResponseDTO dentist;
    private LocalDate pastMedicalDate;
    private String diagnosisName;
    private String treatmentName;
    private String note;
}
