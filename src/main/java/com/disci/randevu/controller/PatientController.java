package com.disci.randevu.controller;

import com.disci.randevu.dto.patientDTO.PatientCreateDTO;
import com.disci.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.disci.randevu.dto.patientDTO.PatientUpdateDTO;
import com.disci.randevu.service.patientService.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<PatientFullResponseDTO> createPatient(
            @Valid @RequestBody PatientCreateDTO patientCreateDTO){
        PatientFullResponseDTO createdPatient = patientService.createPatient(patientCreateDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PatientFullResponseDTO> updatePatient(
            @Valid @RequestBody PatientUpdateDTO patientUpdateDTO){
        PatientFullResponseDTO updatedPatient = patientService.updatePatient(patientUpdateDTO);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientFullResponseDTO> getPatientById(@PathVariable Long id){
        PatientFullResponseDTO patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/limited")
    public ResponseEntity<List<PatientLimitedResponseDTO>> getAllPatientsLimited(){
        List<PatientLimitedResponseDTO> patients = patientService.getAllPatientsLimited();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/full")
    public ResponseEntity<List<PatientFullResponseDTO>> getAllPatientsFull(){
        List<PatientFullResponseDTO> patients = patientService.getAllPatientsFull();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
