package com.disci.randevu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dentists")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Dişçi ismi boş bırakılamaz!")
    @Size(min=3, max=20, message = "İsim, 3-20 karakter arasında olmalıdır.")
    @Column(name = "dentist_first_name", nullable = false)
    private String dentistFirstName;

    @NotBlank(message = "Dişçi soyismi boş bırakılamaz!")
    @Size(min=2, max=20, message = "Soyisim, 2-20 karakter arasında olmalıdır.")
    @Column(name = "dentist_last_name", nullable = false)
    private String dentistLastName;

    @NotNull(message = "Dişçi doğum tarihi boş bırakılamaz!")
    @Column(name = "dentist_date_of_birth", nullable = false)
    private String dentistEmail;

    @Pattern(regexp = "^[0-9]{10,11}$", message = "Geçerli bir telefon numarası giriniz!")
    @NotBlank(message = "Telefon numarası boş bırakılamaz!")
    @Column(name = "dentist_phone", nullable = false, unique = true)
    private String dentistPhone;

}
