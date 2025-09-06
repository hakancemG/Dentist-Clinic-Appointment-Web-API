package com.disci.randevu.dto.dentistDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DentistLimitedResponseDTO {
    private Long id;
    private String dentistFirstName;
    private String dentistLastName;
}
