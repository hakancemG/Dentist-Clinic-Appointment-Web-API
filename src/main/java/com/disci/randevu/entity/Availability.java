package com.disci.randevu.entity;

import com.disci.randevu.enums.AvailabilityStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "availabilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FutureOrPresent(message = "Müsaitlik tarihi geçmiş bir tarihte olamaz!")
    @NotNull(message = "Müsaitlik durumu boş bırkaılamaz!")
    @Column(name = "availability_date", nullable = false)
    private LocalDate availabilityDate;

    @NotNull(message = "Başlangıç saati boş bırakılamaz!")
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @NotNull(message = "Bitiş saati boş bırakılamaz!")
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Randevu durumu boş bırakılamaz!")
    @Column(name = "availability_status")
    private AvailabilityStatus availabilityStatus = AvailabilityStatus.UNKNOWN;

    private boolean isTimeValid(){
        if(startTime == null || endTime == null) return true;

        return startTime.isBefore(endTime);
    }

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

}
