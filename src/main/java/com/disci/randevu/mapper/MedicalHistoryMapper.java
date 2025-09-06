package com.disci.randevu.mapper;

import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryLimitedResponseDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;
import com.disci.randevu.entity.Dentist;
import com.disci.randevu.entity.MedicalHistory;
import com.disci.randevu.entity.Patient;

public class MedicalHistoryMapper {
    // DTO'dan Entity'ye.
    public static MedicalHistory toEntity(MedicalHistoryCreateDTO createDTO, Patient patient, Dentist dentist){
        if(createDTO == null) return null;

        return MedicalHistory.builder()
                .pastMedicalDate(createDTO.getPastMedicalDate())
                .diagnosisName(createDTO.getDiagnosisName())
                .treatmentName(createDTO.getTreatmentName())
                .note(createDTO.getNote())
                .patient(patient)
                .dentist(dentist)
                .build();
    }

    public static MedicalHistory toEntity(MedicalHistoryUpdateDTO updateDTO, Patient patient, Dentist dentist){
        if(updateDTO == null) return null;

        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setId(updateDTO.getId());
        medicalHistory.setPastMedicalDate(updateDTO.getPastMedicalDate());
        medicalHistory.setDiagnosisName(updateDTO.getDiagnosisName());
        medicalHistory.setTreatmentName(updateDTO.getTreatmentName());
        medicalHistory.setNote(updateDTO.getNote());
        medicalHistory.setPatient(patient);
        medicalHistory.setDentist(dentist);

        return medicalHistory;
    }

    // Entity'den DTO'ya.
    public static MedicalHistoryFullResponseDTO toFullResponseDTO(MedicalHistory medicalHistory){
        if(medicalHistory == null) return null;

        return MedicalHistoryFullResponseDTO.builder()
                .id(medicalHistory.getId())
                .patient(PatientMapper.toLimitedResponseDTO(medicalHistory.getPatient()))
                .dentist(DentistMapper.toLimitedResponseDTO(medicalHistory.getDentist()))
                .pastMedicalDate(medicalHistory.getPastMedicalDate())
                .diagnosisName(medicalHistory.getDiagnosisName())
                .treatmentName(medicalHistory.getTreatmentName())
                .note(medicalHistory.getNote())
                .build();
    }

    public static MedicalHistoryLimitedResponseDTO toLimitedResponseDTO(MedicalHistory medicalHistory){
        if(medicalHistory == null) return null;

        return MedicalHistoryLimitedResponseDTO.builder()
                .id(medicalHistory.getId())
                .pastMedicalDate(medicalHistory.getPastMedicalDate())
                .build();
    }
}
