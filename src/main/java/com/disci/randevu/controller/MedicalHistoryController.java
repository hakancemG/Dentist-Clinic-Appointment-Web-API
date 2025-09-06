package com.disci.randevu.controller;

import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.disci.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;
import com.disci.randevu.service.medicalHistoryService.MedicalHistoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-histories")
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService){
        this.medicalHistoryService = medicalHistoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<MedicalHistoryFullResponseDTO> createMedicalHistory(
            @Valid @RequestBody MedicalHistoryCreateDTO medicalHistoryCreateDTO){
        MedicalHistoryFullResponseDTO createdMedicalHistory = medicalHistoryService
                .createMedicalHistory(medicalHistoryCreateDTO);

        return new ResponseEntity<>(createdMedicalHistory, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MedicalHistoryFullResponseDTO> updateMedicalHistory(
            @Valid @RequestBody MedicalHistoryUpdateDTO medicalHistoryUpdateDTO){
        MedicalHistoryFullResponseDTO updatedMedicalHistory = medicalHistoryService
                .updateMedicalHistory(medicalHistoryUpdateDTO);

        return new ResponseEntity<>(updatedMedicalHistory, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistoryFullResponseDTO> getMedicalHistoryById(@PathVariable Long id){
        MedicalHistoryFullResponseDTO medicalHistory = medicalHistoryService.getMedicalHistoryById(id);

        return new ResponseEntity<>(medicalHistory, HttpStatus.OK);
    }

    @GetMapping("/by-patient/{id}")
    public ResponseEntity<List<MedicalHistoryFullResponseDTO>> getMedicalHistoryiesByPatientId(
            @PathVariable("id") Long patientId){
        List<MedicalHistoryFullResponseDTO> medicalHistories = medicalHistoryService
                .getMedicalHistoriesByPatientId(patientId);

        return new ResponseEntity<>(medicalHistories, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long id){
        medicalHistoryService.deleteMedicalHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
