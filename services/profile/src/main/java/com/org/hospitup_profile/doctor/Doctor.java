package com.org.hospitup_profile.doctor;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long doctorId;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    @Email
    private String email;

    private String address;

    private String specialty;

}
