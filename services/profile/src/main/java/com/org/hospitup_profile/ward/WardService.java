package com.org.hospitup_profile.ward;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;

    public List<Ward> getWards(String param) {
        return wardRepository.findAll();
    }

    public Ward getWard(String param) {
        try {
            Long id = Long.parseLong(param);
            Optional<Ward> patient = wardRepository.findById(id);
            return patient.orElse(null); // or throw custom exception if preferred
        } catch (NumberFormatException e) {
            return null; // or handle invalid ID
        }
    }

    public Ward createWard(Ward patient) {
        return wardRepository.save(patient);
    }
}
