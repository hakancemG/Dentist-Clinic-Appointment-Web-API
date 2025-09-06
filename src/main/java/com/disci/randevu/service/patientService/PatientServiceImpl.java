package com.disci.randevu.service.patientService;

import com.disci.randevu.dto.patientDTO.PatientCreateDTO;
import com.disci.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientUpdateDTO;
import com.disci.randevu.entity.Patient;
import com.disci.randevu.exceptions.NotFoundException;
import com.disci.randevu.mapper.PatientMapper;
import com.disci.randevu.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientFullResponseDTO createPatient(PatientCreateDTO patientCreateDTO){
        Patient patient = PatientMapper.toEntity(patientCreateDTO);
        patientRepository.save(patient);
        return PatientMapper.toFullResponseDTO(patient);
    }

    @Override
    public PatientFullResponseDTO updatePatient(PatientUpdateDTO patientUpdateDTO){
        Patient existingPatient = patientRepository.findById(patientUpdateDTO.getId())
                .orElseThrow(()-> new NotFoundException("Hasta bulunmadı!"));

        Patient updatedPatient = PatientMapper.toEntity(patientUpdateDTO, existingPatient);
        patientRepository.save(updatedPatient);
        return PatientMapper.toFullResponseDTO(updatedPatient);
    }

    @Override
    public PatientFullResponseDTO getPatientById(Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hasta Bulunamadı!"));

        return PatientMapper.toFullResponseDTO(patient);
    }

    @Override
    public List<PatientLimitedResponseDTO> getAllPatientsLimited(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientFullResponseDTO> getAllPatientsFull(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}
