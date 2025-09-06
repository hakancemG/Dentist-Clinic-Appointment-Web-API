package com.disci.randevu.dto.appointmentDTO;

import com.disci.randevu.dto.dentistDTO.DentistLimitedResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.disci.randevu.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentFullResponseDTO {
    private Long id;
    private LocalDate appointmentDate;
    private AppointmentStatus appointmentStatus;
    private PatientLimitedResponseDTO patient;
    private DentistLimitedResponseDTO dentist;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
}
