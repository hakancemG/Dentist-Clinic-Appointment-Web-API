package com.disci.randevu.entity;

import com.disci.randevu.enums.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Randevu tarihi boş bırakılamaz")
    @FutureOrPresent(message = "Randevu tarihi geçmiş bir tarihte olamaz!")
    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Randevu durumu boş bırakılamaz!")
    @Column(name = "appointment_status")
    private AppointmentStatus appointmentStatus = AppointmentStatus.PENDING;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @PrePersist
    public void createdAt(){
        createdAt = LocalDate.now();
    }

    @PreUpdate
    public void updatedAt(){
        updatedAt = LocalDate.now();
    }

    @PreRemove
    public void deletedAt(){
        deletedAt = LocalDate.now();
    }
}