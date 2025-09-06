package com.disci.randevu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hasta ismi boş bırakılamaz!")
    @Size(min=3, max=20, message = "İsim, 3-20 karakter arasında olmalıdır.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Hasta soyismi boş bırakılamaz!")
    @Size(min=2, max=20, message = "Soyisim, 2-20 karakter arasında olmalıdır.")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @PastOrPresent(message = "Hasta doğum tarihi geçmiş bir tarihte olmalıdır!")
    @NotNull(message = "Hasta doğum tarihi boş bırakılamaz!")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Email(message = "Geçerli bir e-mail giriniz!")
    @Column(name = "email", unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]{10,11}$", message = "Geçerli bir telefon numarası giriniz!")
    @NotBlank(message = "Telefon numarası boş bırakılamaz!")
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @PrePersist
    public void createdAt(){
        createdAt = LocalDate.now();
    }

    @PreUpdate
    public void updatedAt(){
        updatedAt = LocalDate.now();
    }

    @PreRemove
    public void deletedAt(){
        deletedAt = LocalDate.now();
    }

}
