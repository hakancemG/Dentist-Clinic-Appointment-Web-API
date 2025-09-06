package com.disci.randevu.dto.medicalHistoryDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalHistoryUpdateDTO {
    @NotNull(message = "ID boş bırakılamaz!")
    private Long id;

    @NotNull(message = "Hasta ID'si boş bırakılamaz!")
    private Long patientId;

    @NotNull(message = "Dişçi ID'si boş bırakılamaz!")
    private Long dentistId;

    @PastOrPresent(message = "Hasta tedavi geçmişi gelecek bir tarih olamaz!")
    @NotNull(message = "Hasta tedavi geçmişi tarihi boş bırakılamaz!")
    @Column(name = "past_medical_date", nullable = false)
    private LocalDate pastMedicalDate;

    @NotBlank(message = "Hasta tedavi geçmişinde teşhis ismi boş bırakılamaz!")
    @Size(min=2, max=50, message = "Teşhis kısmı 2-50 karakter arasında olmalıdır!")
    @Column(name = "diagnosis_name", nullable = false)
    private String diagnosisName;

    @NotBlank(message = "Hasta tedavi geçmişinde tedavi ismi boş bırakılamaz!")
    @Size(min=2, max=100, message = "Tedavi kısmı 2-100 karakter arasında olmalıdır!")
    @Column(name = "treatment_name", nullable = false)
    private String treatmentName;

    @NotBlank(message = "Hasta tedavi geçmişinde not boş bırakılamaz!")
    @Column(name = "note", nullable = false)
    private String note;
}
