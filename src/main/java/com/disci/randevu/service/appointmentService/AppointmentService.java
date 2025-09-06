package com.disci.randevu.service.appointmentService;

import com.disci.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentUpdateDTO;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    AppointmentFullResponseDTO createAppointment(AppointmentCreateDTO appointmentCreateDTO);

    AppointmentFullResponseDTO updateAppointment(AppointmentUpdateDTO appointmentUpdateDTO);

    AppointmentFullResponseDTO getAppointmentById(Long id);

    List<AppointmentFullResponseDTO> getAppointmentsByAppointmentDateAndDentistId(LocalDate appointmentDate, Long dentistId);

    void deleteAppointment(Long id);

}