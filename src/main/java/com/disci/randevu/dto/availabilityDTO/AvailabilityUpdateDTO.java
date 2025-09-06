package com.disci.randevu.dto.availabilityDTO;

import com.disci.randevu.enums.AvailabilityStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
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
public class AvailabilityUpdateDTO {

    @NotNull(message = "ID boş bırakılamaz!")
    private Long id;

    @FutureOrPresent(message = "Müsaitlik tarihi geçmiş bir tarihte olamaz!")
    @NotNull(message = "Müsaitlik durumu boş bırkaılamaz!")
    @Column(name = "availability_date", nullable = false)
    private LocalDate availabilityDate;

    @NotNull(message = "Başlangıç saati boş bırakılamaz!")
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Randevu durumu boş bırakılamaz!")
    @Column(name = "availability_status")
    private AvailabilityStatus availabilityStatus = AvailabilityStatus.UNKNOWN;

    @NotNull(message = "Bitiş saati boş bırakılamaz!")
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;
}
