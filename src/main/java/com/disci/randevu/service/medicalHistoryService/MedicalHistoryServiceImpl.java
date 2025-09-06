package com.disci.randevu.service;

import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;
import com.disci.randevu.entity.Dentist;
import com.disci.randevu.entity.MedicalHistory;
import com.disci.randevu.entity.Patient;
import com.disci.randevu.exceptions.NotFoundException;
import com.disci.randevu.mapper.MedicalHistoryMapper;
import com.disci.randevu.repository.DentistRepository;
import com.disci.randevu.repository.MedicalHistoryRepository;
import com.disci.randevu.repository.PatientRepository;
import com.disci.randevu.service.medicalHistoryService.MedicalHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final PatientRepository patientRepository;
    private final DentistRepository dentistRepository;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository,
                                     PatientRepository patientRepository,
                                     DentistRepository dentistRepository){
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
    }

    @Override
    public MedicalHistoryFullResponseDTO createMedicalHistory(MedicalHistoryCreateDTO createDTO){
        Patient patient = patientRepository.findById(createDTO.getPatientId())
                .orElseThrow(() -> new NotFoundException("Hasta bulunamadı!"));
        Dentist dentist = dentistRepository.findById(createDTO.getDentistId())
                .orElseThrow(() -> new NotFoundException("Dişçi bulunamadı!"));

        MedicalHistory medicalHistory = MedicalHistoryMapper.toEntity(createDTO, patient, dentist);
        medicalHistoryRepository.save(medicalHistory);
        return  MedicalHistoryMapper.toFullResponseDTO(medicalHistory);
    }

    @Override
    public MedicalHistoryFullResponseDTO updateMedicalHistory(MedicalHistoryUpdateDTO updateDTO){
        MedicalHistory existingMedicalHistory = medicalHistoryRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Tedavi geçmişi bulunamadı!"));

        MedicalHistory updatedMedicalHistory = MedicalHistoryMapper.toEntity(updateDTO,
                existingMedicalHistory.getPatient(),
                existingMedicalHistory.getDentist()
        );

        medicalHistoryRepository.save(updatedMedicalHistory);
        return MedicalHistoryMapper.toFullResponseDTO(updatedMedicalHistory);
    }

    @Override
    public MedicalHistoryFullResponseDTO getMedicalHistoryById(Long id){
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Tedavi geçmişi bulunamadı!"));

        return MedicalHistoryMapper.toFullResponseDTO(medicalHistory);
    }

    @Override
    public List<MedicalHistoryFullResponseDTO> getMedicalHistoriesByPatientId(Long patientId){
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientId(patientId);

        return medicalHistories.stream()
                .map(MedicalHistoryMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMedicalHistory(Long id){
        medicalHistoryRepository.deleteById(id);
    }
}
