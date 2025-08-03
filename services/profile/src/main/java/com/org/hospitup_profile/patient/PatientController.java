package com.org.hospitup_profile.patient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/list")
    public List<Patient> getPatients(@RequestParam(required = false) String param) {
        return patientService.getPatients(param);
    }

    @GetMapping
    public Patient getPatient(@RequestParam String id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        patient.setGender("null");
        patient.setName("test");
        return patientService.createPatient(patient);
    }

}
