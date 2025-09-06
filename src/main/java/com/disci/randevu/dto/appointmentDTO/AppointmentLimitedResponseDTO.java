package com.disci.randevu.dto.appointmentDTO;

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
public class AppointmentLimitedResponseDTO {
    private Long id;
    private LocalDate appointmentDate;
    private AppointmentStatus appointmentStatus;
}
