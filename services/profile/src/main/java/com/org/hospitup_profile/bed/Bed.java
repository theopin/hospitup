package com.org.hospitup_profile.bed;

import com.org.hospitup_profile.patient.Patient;
import com.org.hospitup_profile.ward.Ward;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "bed")
@Data
@Builder

public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long bedId;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
