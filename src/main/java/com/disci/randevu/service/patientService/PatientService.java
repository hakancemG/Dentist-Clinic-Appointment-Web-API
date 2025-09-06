package com.disci.randevu.service.patientService;

import com.disci.randevu.dto.patientDTO.PatientCreateDTO;
import com.disci.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientUpdateDTO;

import java.util.List;

public interface PatientService {
    PatientFullResponseDTO createPatient(PatientCreateDTO patientCreateDTO);

    PatientFullResponseDTO updatePatient(PatientUpdateDTO patientUpdateDTO);

    PatientFullResponseDTO getPatientById(Long id);

    List<PatientLimitedResponseDTO> getAllPatientsLimited();

    List<PatientFullResponseDTO> getAllPatientsFull();

    void deletePatient(Long id);
}
