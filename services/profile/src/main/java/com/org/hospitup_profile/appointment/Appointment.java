package com.org.hospitup_profile.appointment;

import java.time.LocalDateTime;

import com.org.hospitup_profile.doctor.Doctor;
import com.org.hospitup_profile.patient.Patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "appointments")
@Data
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long appointmentId;

    private LocalDateTime appointmentTime;

    private String reason;  // e.g., consultation, follow-up

    private String status; // scheduled, completed, cancelled, etc.

    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

}
