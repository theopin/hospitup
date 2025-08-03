package com.org.hospitup_profile.doctor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/list")
    public List<Doctor> getDoctors(@RequestParam(required = false) String param) {
        return doctorService.getDoctors(param);
    }

    @GetMapping
    public Doctor getDoctor(@RequestParam String id) {
        return doctorService.getDoctor(id);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        doctor.setGender("null");
        doctor.setName("test");
        return doctorService.createDoctor(doctor);
    }

}
