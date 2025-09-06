package com.disci.randevu.service.availabilityService;

import com.disci.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;
import com.disci.randevu.entity.Availability;
import com.disci.randevu.entity.Dentist;
import com.disci.randevu.exceptions.NotFoundException;
import com.disci.randevu.mapper.AvailabilityMapper;
import com.disci.randevu.repository.AvailabilityRepository;
import com.disci.randevu.repository.DentistRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityServiceImpl implements AvailabilityService{
    private final AvailabilityRepository availabilityRepository;
    private final DentistRepository dentistRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository,
                                   DentistRepository dentistRepository){
        this.availabilityRepository = availabilityRepository;
        this.dentistRepository = dentistRepository;
    }

    @Override
    public AvailabilityFullResponseDTO createAvailability(AvailabilityCreateDTO createDTO){
        Dentist dentist = dentistRepository.findById(createDTO.getDentistId())
                .orElseThrow(() -> new NotFoundException("Dişçi bulunamadı!"));

        Availability availability = AvailabilityMapper.toEntity(createDTO, dentist);
        availabilityRepository.save(availability);
        return AvailabilityMapper.toFullResponseDTO(availability);
    }

    @Override
    public AvailabilityFullResponseDTO updateAvailability(AvailabilityUpdateDTO updateDTO){
        Availability existingAvailability = availabilityRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Müsaitlik bulunamadı!"));

        // Sadece güncellenecek alanları mevcut nesne üzerinde set et.
        existingAvailability.setAvailabilityDate(updateDTO.getAvailabilityDate());
        existingAvailability.setAvailabilityStatus(updateDTO.getAvailabilityStatus());
        existingAvailability.setStartTime(updateDTO.getStartTime());
        existingAvailability.setEndTime(updateDTO.getEndTime());

        // Dişçi bilgisini değiştirmeye gerek yok, zaten var olan bilgi korunur.

        Availability updatedAvailability = availabilityRepository.save(existingAvailability);

        availabilityRepository.save(updatedAvailability);
        return AvailabilityMapper.toFullResponseDTO(updatedAvailability);
    }

    @Override
    public AvailabilityFullResponseDTO getAvailabilityById(Long id){
        Availability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Müsaitlik bulunamadı!"));

        return AvailabilityMapper.toFullResponseDTO(availability);
    }

    @Override
    public List<AvailabilityFullResponseDTO> findByDentistIdAndAvailabilityDate(Long dentistId,
                                                                                LocalDate availabilityDate){
        List<Availability> availabilities = availabilityRepository
                .findByDentistIdAndAvailabilityDate(dentistId, availabilityDate);

        return availabilities.stream()
                .map(AvailabilityMapper::toFullResponseDTO)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAvailability(Long id){
        availabilityRepository.deleteById(id);
    }
}
