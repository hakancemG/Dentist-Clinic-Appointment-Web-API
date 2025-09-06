package com.disci.randevu.mapper;

import com.disci.randevu.dto.patientDTO.PatientCreateDTO;
import com.disci.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientUpdateDTO;
import com.disci.randevu.entity.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {
    // DTO'dan Entity'ye.
    public static Patient toEntity(PatientCreateDTO patientCreateDTO){
        if (patientCreateDTO == null) return null;

        return Patient.builder()
                .firstName(patientCreateDTO.getFirstName())
                .lastName(patientCreateDTO.getLastName())
                .email(patientCreateDTO.getEmail())
                .phone(patientCreateDTO.getPhone())
                .dateOfBirth(patientCreateDTO.getDateOfBirth())
                .build();
    }

    public static Patient toEntity(PatientUpdateDTO patientUpdateDTO, Patient patient){
        if(patientUpdateDTO == null) return null;

        patient.setFirstName(patientUpdateDTO.getFirstName());
        patient.setLastName(patientUpdateDTO.getLastName());
        patient.setEmail(patientUpdateDTO.getEmail());
        patient.setPhone(patientUpdateDTO.getPhone());
        patient.setDateOfBirth(patientUpdateDTO.getDateOfBirth());

        return patient;
    }

    // Entity'den DTO'ya.
    public static PatientFullResponseDTO toFullResponseDTO(Patient patient){
        if(patient == null) return null;

        return PatientFullResponseDTO.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .dateOfBirth(patient.getDateOfBirth())
                .build();
    }

    public static PatientLimitedResponseDTO toLimitedResponseDTO(Patient patient){
        if(patient == null) return null;

        return PatientLimitedResponseDTO.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .build();
    }

    // Entity Listesinden DTO'ya.
    public static List<PatientLimitedResponseDTO> toLimitedResponseDTO(List<Patient> patients){
        return patients.stream()
                .map(PatientMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }
}