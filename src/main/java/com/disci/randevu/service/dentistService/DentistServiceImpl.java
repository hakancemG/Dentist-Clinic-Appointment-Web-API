package com.disci.randevu.service.dentistService;

import com.disci.randevu.dto.dentistDTO.DentistCreateDTO;
import com.disci.randevu.dto.dentistDTO.DentistFullResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistLimitedResponseDTO;
import com.disci.randevu.dto.dentistDTO.DentistUpdateDTO;
import com.disci.randevu.entity.Dentist;
import com.disci.randevu.exceptions.NotFoundException;
import com.disci.randevu.mapper.DentistMapper;
import com.disci.randevu.repository.DentistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistServiceImpl implements DentistService{
    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository){
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DentistFullResponseDTO createDentist(DentistCreateDTO dentistCreateDTO){
        Dentist dentist = DentistMapper.toEntity(dentistCreateDTO);
        dentistRepository.save(dentist);
        return DentistMapper.toFullResponseDTO(dentist);
    }

    @Override
    public DentistFullResponseDTO updateDentist(DentistUpdateDTO dentistUpdateDTO){
        Dentist existingDentist = dentistRepository.findById(dentistUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Dişçi bulunamadı!"));

        Dentist updatedDentist = DentistMapper.toEntity(dentistUpdateDTO);
        dentistRepository.save(updatedDentist);
        return DentistMapper.toFullResponseDTO(updatedDentist);
    }

    @Override
    public DentistFullResponseDTO getDentistById(Long id){
        Dentist existingDentist = dentistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dişçi bulunamadı!"));

        return DentistMapper.toFullResponseDTO(existingDentist);
    }

    @Override
    public List<DentistLimitedResponseDTO> getAllDentistsLimited(){
        List<Dentist> dentists = dentistRepository.findAll();
        return dentists.stream()
                .map(DentistMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DentistFullResponseDTO> getAllDentistsFull(){
        List<Dentist> dentists = dentistRepository.findAll();
        return dentists.stream()
                .map(DentistMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDentist(Long id){
        dentistRepository.deleteById(id);
    }
}
