package com.disci.randevu.service.medicalHistoryService;

import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;

import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryFullResponseDTO createMedicalHistory(MedicalHistoryCreateDTO createDTO);

    MedicalHistoryFullResponseDTO updateMedicalHistory(MedicalHistoryUpdateDTO updateDTO);

    MedicalHistoryFullResponseDTO getMedicalHistoryById(Long id);

    List<MedicalHistoryFullResponseDTO> getMedicalHistoriesByPatientId(Long patientId);

    void deleteMedicalHistory(Long id);
}
