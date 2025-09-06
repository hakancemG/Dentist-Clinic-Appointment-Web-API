package com.disci.randevu.dto.appointmentDTO;

import com.disci.randevu.enums.AppointmentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentUpdateDTO {

    @NotNull(message = "ID boş bırakılamaz!")
    private Long id;

    @NotNull(message = "Randevu tarihi boş bırakılamaz")
    @FutureOrPresent(message = "Randevu tarihi geçmiş bir tarihte olamaz!")
    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status")
    @NotNull(message = "Randevu durumu boş bırakılamaz!")
    private AppointmentStatus appointmentStatus;

    @NotNull(message = "Dişçi ID'si boş bırakılamaz!")
    private Long dentistId;
}
