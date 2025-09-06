package com.disci.randevu.service.appointmentService;

import com.disci.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.disci.randevu.dto.appointmentDTO.AppointmentUpdateDTO;
import com.disci.randevu.entity.Appointment;
import com.disci.randevu.entity.Dentist;
import com.disci.randevu.entity.Patient;
import com.disci.randevu.exceptions.NotFoundException;
import com.disci.randevu.mapper.AppointmentMapper;
import com.disci.randevu.repository.AppointmentRepository;
import com.disci.randevu.repository.DentistRepository;
import com.disci.randevu.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DentistRepository dentistRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  PatientRepository patientRepository,
                                  DentistRepository dentistRepository){
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
    }

    @Override
    public AppointmentFullResponseDTO createAppointment(AppointmentCreateDTO appointmentCreateDTO){
        Patient patient = patientRepository.findById(appointmentCreateDTO.getPatientId())
                .orElseThrow(() -> new NotFoundException("Hasta bulunamadı!"));
        Dentist dentist = dentistRepository.findById(appointmentCreateDTO.getDentistId())
                .orElseThrow(() -> new NotFoundException("Dişçi bulunamadı!"));

        Appointment updatedAppointment = AppointmentMapper.toEntity(appointmentCreateDTO, patient, dentist);
        appointmentRepository.save(updatedAppointment);
        return AppointmentMapper.toFullResponseDTO(updatedAppointment);
    }

    @Override
    public AppointmentFullResponseDTO updateAppointment(AppointmentUpdateDTO appointmentUpdateDTO){
        Appointment existingAppoinment = appointmentRepository.findById(appointmentUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Randevu bulunamadı!"));

        Appointment updatedAppointment = AppointmentMapper.toEntity(appointmentUpdateDTO, existingAppoinment);
        appointmentRepository.save(updatedAppointment);
        return AppointmentMapper.toFullResponseDTO(updatedAppointment);
    }

    @Override
    public AppointmentFullResponseDTO getAppointmentById(Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Randevu bulunamadı!"));
        return AppointmentMapper.toFullResponseDTO(appointment);
    }

    @Override
    public List<AppointmentFullResponseDTO> getAppointmentsByAppointmentDateAndDentistId(LocalDate appointmentDate, Long dentistId){
        List<Appointment> appointments = appointmentRepository.findByAppointmentDateAndDentistId(appointmentDate, dentistId);
        return AppointmentMapper.toFullResponseDTOList(appointments);
    }

    @Override
    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

}
