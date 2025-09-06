package com.disci.randevu.dto.dentistDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DentistFullResponseDTO {
    private Long id;
    private String dentistFirstName;
    private String dentistLastName;
    private String dentistEmail;
    private String dentistPhone;
}
