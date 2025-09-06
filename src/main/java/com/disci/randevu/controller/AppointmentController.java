package com.disci.randevu.controller;

import com.disci.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentUpdateDTO;
import com.disci.randevu.service.appointmentService.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentFullResponseDTO> createAppointment(
            @Valid @RequestBody AppointmentCreateDTO appointmentCreateDTO){
        AppointmentFullResponseDTO createdAppointment = appointmentService.createAppointment(appointmentCreateDTO);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AppointmentFullResponseDTO> updateAppoinment(
            @Valid @RequestBody AppointmentUpdateDTO appointmentUpdateDTO){
        AppointmentFullResponseDTO updatedAppointment = appointmentService.updateAppointment(appointmentUpdateDTO);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentFullResponseDTO> getAppointmentById(@PathVariable Long id){
        AppointmentFullResponseDTO appointent = appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(appointent, HttpStatus.OK);
    }

    @GetMapping("/by-date-and-dentist")
    public ResponseEntity<List<AppointmentFullResponseDTO>> getAppointmentsByAppointmentDateAndDentistId(
            @RequestParam("appointmentDate") LocalDate appointmentDate,
            @RequestParam("dentistId") Long dentistId){
        List<AppointmentFullResponseDTO> appointments = appointmentService
                .getAppointmentsByAppointmentDateAndDentistId(appointmentDate, dentistId);

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
