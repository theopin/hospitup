package com.org.hospitup_profile.appointment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/list")
    public List<Appointment> getAppointments(@RequestParam(required = false) String param) {
        return appointmentService.getAppointments(param);
    }

    @GetMapping
    public Appointment getAppointment(@RequestParam String id) {
        return appointmentService.getAppointment(id);
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }
}
