package com.disci.randevu.service.dentistService;

import com.disci.randevu.dto.dentistDTO.DentistCreateDTO;
import com.disci.randevu.dto.dentistDTO.DentistFullResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistLimitedResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistUpdateDTO;

import java.util.List;

public interface DentistService {
    DentistFullResponseDTO createDentist(DentistCreateDTO dentistCreateDTO);

    DentistFullResponseDTO updateDentist(DentistUpdateDTO dentistUpdateDTO);

    DentistFullResponseDTO getDentistById(Long id);

    List<DentistLimitedResponseDTO> getAllDentistsLimited();

    List<DentistFullResponseDTO> getAllDentistsFull();

    void deleteDentist(Long id);
}
