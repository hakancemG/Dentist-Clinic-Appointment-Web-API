package com.disci.randevu.mapper;

import com.disci.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentLimitedResponseDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentUpdateDTO;
import com.disci.randevu.entity.Appointment;
import com.disci.randevu.entity.Dentist;
import com.disci.randevu.entity.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentMapper {
    // DTO'dan Entity'ye.
    public static Appointment toEntity(AppointmentCreateDTO appointmentCreateDTO, Patient patient, Dentist dentist){
        if(appointmentCreateDTO == null) return null;

        return Appointment.builder()
                .appointmentDate(appointmentCreateDTO.getAppointmentDate())
                .patient(patient)
                .dentist(dentist)
                .appointmentStatus(appointmentCreateDTO.getAppointmentStatus())
                .build();
    }

    public static Appointment toEntity(AppointmentUpdateDTO appointmentUpdateDTO, Appointment existingAppointment){
        if(appointmentUpdateDTO == null || existingAppointment == null) return null;

        existingAppointment.setAppointmentDate(appointmentUpdateDTO.getAppointmentDate());
        existingAppointment.setAppointmentStatus(appointmentUpdateDTO.getAppointmentStatus());
        return existingAppointment;
    }

    // Entity'den DTO'ya.
    public static AppointmentFullResponseDTO toFullResponseDTO(Appointment appointment){
        if(appointment == null) return null;

        return AppointmentFullResponseDTO.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentStatus(appointment.getAppointmentStatus())
                .patient(PatientMapper.toLimitedResponseDTO(appointment.getPatient()))
                .dentist(DentistMapper.toLimitedResponseDTO(appointment.getDentist()))
                .createdAt(appointment.getCreatedAt())
                .updatedAt(appointment.getUpdatedAt())
                .deletedAt(appointment.getDeletedAt())
                .build();
    }

    public static AppointmentLimitedResponseDTO toLimitedResponseDTO(Appointment appointment){
        if(appointment == null) return null;

        return AppointmentLimitedResponseDTO.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentStatus(appointment.getAppointmentStatus())
                .build();
    }

    public static List<AppointmentFullResponseDTO> toFullResponseDTOList(List<Appointment> appointments){
        return appointments.stream()
                .map(AppointmentMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }

    public static List<AppointmentLimitedResponseDTO> toLimitedResponseDTOList(List<Appointment> appointments){
        return appointments.stream()
                .map(AppointmentMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }

}
