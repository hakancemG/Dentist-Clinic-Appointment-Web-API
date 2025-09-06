package com.disci.randevu.controller;

import com.disci.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;
import com.disci.randevu.service.availabilityService.AvailabilityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availabilities")
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService){
        this.availabilityService = availabilityService;
    }

    @PostMapping("/create")
    public ResponseEntity<AvailabilityFullResponseDTO> createAvailability(
            @Valid @RequestBody AvailabilityCreateDTO availabilityCreateDTO){
        AvailabilityFullResponseDTO createdAvailability = availabilityService
                .createAvailability(availabilityCreateDTO);

        return new ResponseEntity<>(createdAvailability, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AvailabilityFullResponseDTO> updateAvailability(
            @Valid @RequestBody AvailabilityUpdateDTO availabilityUpdateDTO){
        AvailabilityFullResponseDTO updatedAvailability = availabilityService
                .updateAvailability(availabilityUpdateDTO);

        return new ResponseEntity<>(updatedAvailability, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailabilityFullResponseDTO> getAvailabilityById(@PathVariable Long id){
        AvailabilityFullResponseDTO availability = availabilityService.getAvailabilityById(id);
        return new ResponseEntity<>(availability, HttpStatus.OK);
    }

    @GetMapping("/dentist/{dentistId}/availabilityDate/{availabilityDate}")
    public ResponseEntity<List<AvailabilityFullResponseDTO>> getAvailabilitiesByDentistIdAndAvailabilityDate(
            @PathVariable Long dentistId,
            @PathVariable LocalDate availabilityDate){
        List<AvailabilityFullResponseDTO> availabilities = availabilityService
                .findByDentistIdAndAvailabilityDate(dentistId, availabilityDate);
        return new ResponseEntity<>(availabilities, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id){
        availabilityService.deleteAvailability(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
