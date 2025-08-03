package com.org.hospitup_profile.doctor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getDoctors(String param) {
        return doctorRepository.findAll();
    }

    public Doctor getDoctor(String param) {
        try {
            Long id = Long.parseLong(param);
            Optional<Doctor> doctor = doctorRepository.findById(id);
            return doctor.orElse(null); // or throw custom exception if preferred
        } catch (NumberFormatException e) {
            return null; // or handle invalid ID
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
