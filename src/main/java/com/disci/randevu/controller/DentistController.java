package com.disci.randevu.controller;

import com.disci.randevu.dto.dentistDTO.DentistCreateDTO;
import com.disci.randevu.dto.dentistDTO.DentistFullResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistLimitedResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistUpdateDTO;
import com.disci.randevu.entity.Dentist;
import com.disci.randevu.repository.DentistRepository;
import com.disci.randevu.service.dentistService.DentistService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dentists")
public class DentistController {
    private final DentistService dentistService;

    public DentistController(DentistService dentistService){
        this.dentistService = dentistService;
    }

    @PostMapping("/create")
    public ResponseEntity<DentistFullResponseDTO> createDentist(
            @Valid @RequestBody DentistCreateDTO dentistCreateDTO){
        DentistFullResponseDTO createdDentist = dentistService.createDentist(dentistCreateDTO);
        return new ResponseEntity<>(createdDentist, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DentistFullResponseDTO> updateDentist(
            @Valid @RequestBody DentistUpdateDTO dentistUpdateDTO){
        DentistFullResponseDTO updatedDentist = dentistService.updateDentist(dentistUpdateDTO);
        return new ResponseEntity<>(updatedDentist, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistFullResponseDTO> getDentistById(@PathVariable Long id){
        DentistFullResponseDTO dentist = dentistService.getDentistById(id);
        return new ResponseEntity<>(dentist, HttpStatus.OK);
    }

    @GetMapping("/limited")
    public ResponseEntity<List<DentistLimitedResponseDTO>> getAllDentists(){
        List<DentistLimitedResponseDTO> dentists = dentistService.getAllDentistsLimited();
        return new ResponseEntity<>(dentists, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        dentistService.deleteDentist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
