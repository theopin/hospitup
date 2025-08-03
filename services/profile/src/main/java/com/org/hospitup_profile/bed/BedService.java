package com.org.hospitup_profile.bed;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;

    public List<Bed> getBeds(String param) {
        return bedRepository.findAll();
    }

    public Bed getBed(String param) {
        try {
            Long id = Long.parseLong(param);
            Optional<Bed> patient = bedRepository.findById(id);
            return patient.orElse(null); // or throw custom exception if preferred
        } catch (NumberFormatException e) {
            return null; // or handle invalid ID
        }
    }

    public Bed createBed(Bed patient) {
        return bedRepository.save(patient);
    }
}
