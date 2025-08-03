package com.org.hospitup_profile.appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointments(String param) {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment(String param) {
        try {
            Long id = Long.parseLong(param);
            Optional<Appointment> patient = appointmentRepository.findById(id);
            return patient.orElse(null); // or throw custom exception if preferred
        } catch (NumberFormatException e) {
            return null; // or handle invalid ID
        }
    }

    public Appointment createAppointment(Appointment patient) {
        return appointmentRepository.save(patient);
    }
}
