package com.disci.randevu.mapper;

import com.disci.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityLimitedResponseDTO;
import com.disci.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;
import com.disci.randevu.entity.Availability;
import com.disci.randevu.entity.Dentist;

import java.util.List;
import java.util.stream.Collectors;

public class AvailabilityMapper {
    // DTO'dan Entity'ye.
    public static Availability toEntity(AvailabilityCreateDTO createDTO, Dentist dentist){
        if(createDTO == null) return null;

        return Availability.builder()
                .availabilityDate(createDTO.getAvailabilityDate())
                .startTime(createDTO.getStartTime())
                .endTime(createDTO.getEndTime())
                .availabilityStatus(createDTO.getAvailabilityStatus())
                .dentist(dentist)
                .build();
    }

    public static Availability toEntity(AvailabilityUpdateDTO updateDTO){
        if(updateDTO == null) return null;

        Availability availability = new Availability();
        availability.setId(updateDTO.getId());
        availability.setAvailabilityDate(updateDTO.getAvailabilityDate());
        availability.setAvailabilityStatus(updateDTO.getAvailabilityStatus());
        availability.setStartTime(updateDTO.getStartTime());
        availability.setEndTime(updateDTO.getEndTime());
        return  availability;
    }

    // Entity'den DTO'ya.
    public static AvailabilityFullResponseDTO toFullResponseDTO(Availability availability){
        if(availability == null) return null;

        return AvailabilityFullResponseDTO.builder()
                .id(availability.getId())
                .availabilityDate(availability.getAvailabilityDate())
                .availabilityStatus(availability.getAvailabilityStatus())
                .startTime(availability.getStartTime())
                .endTime(availability.getEndTime())
                .dentist(DentistMapper.toLimitedResponseDTO(availability.getDentist()))
                .build();
    }

    public static AvailabilityLimitedResponseDTO toLimitedResponseDTO(Availability availability){
        if(availability == null) return null;

        return AvailabilityLimitedResponseDTO.builder()
                .id(availability.getId())
                .availabilityDate(availability.getAvailabilityDate())
                .availabilityStatus(availability.getAvailabilityStatus())
                .build();
    }

    public static List<AvailabilityFullResponseDTO> toFullResponseDTOList(List<Availability> availabilities){
        return availabilities.stream()
                .map(AvailabilityMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}
