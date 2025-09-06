package com.disci.randevu.mapper;

import com.disci.randevu.dto.dentistDTO.DentistCreateDTO;
import com.disci.randevu.dto.dentistDTO.DentistFullResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistLimitedResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistUpdateDTO;
import com.disci.randevu.entity.Dentist;

import java.util.List;
import java.util.stream.Collectors;

public class DentistMapper {
    // DTO'dan Entity'ye.
    public static Dentist toEntity(DentistCreateDTO dentistCreateDTO){
        if(dentistCreateDTO == null) return null;

        return Dentist.builder()
                .dentistFirstName(dentistCreateDTO.getDentistFirstName())
                .dentistLastName(dentistCreateDTO.getDentistLastName())
                .dentistEmail(dentistCreateDTO.getDentistEmail())
                .dentistPhone(dentistCreateDTO.getDentistPhone())
                .build();
    }

    public static Dentist toEntity(DentistUpdateDTO dentistUpdateDTO){
        if(dentistUpdateDTO == null) return null;

        Dentist dentist = new Dentist();
        dentist.setId(dentistUpdateDTO.getId());
        dentist.setDentistFirstName(dentistUpdateDTO.getDentistFirstName());
        dentist.setDentistLastName(dentistUpdateDTO.getDentistLastName());
        dentist.setDentistEmail(dentistUpdateDTO.getDentistEmail());
        dentist.setDentistPhone(dentistUpdateDTO.getDentistPhone());
        return dentist;
    }

    // Entity'den DTO'ya.
    public static DentistFullResponseDTO toFullResponseDTO(Dentist dentist){
        if(dentist == null) return null;

        return DentistFullResponseDTO.builder()
                .id(dentist.getId())
                .dentistFirstName(dentist.getDentistFirstName())
                .dentistLastName(dentist.getDentistLastName())
                .dentistEmail(dentist.getDentistEmail())
                .dentistPhone(dentist.getDentistPhone())
                .build();
    }

    public static DentistLimitedResponseDTO toLimitedResponseDTO(Dentist dentist){
        if(dentist == null) return null;

        return DentistLimitedResponseDTO.builder()
                .id(dentist.getId())
                .dentistFirstName(dentist.getDentistFirstName())
                .dentistLastName(dentist.getDentistLastName())
                .build();
    }

    // Entity Listesinden DTO Listesine.
    public static List<DentistLimitedResponseDTO> toLimitedResponseDTOList(List<Dentist> dentists){
        return dentists.stream()
                .map(DentistMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }
}
