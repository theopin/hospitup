package com.org.hospitup_profile.ward;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/wards")
public class WardController {

    @Autowired
    private WardService wardService;

    @GetMapping("/list")
    public List<Ward> getWards(@RequestParam(required = false) String param) {
        return wardService.getWards(param);
    }

    @GetMapping
    public Ward getWard(@RequestParam String id) {
        return wardService.getWard(id);
    }

    @PostMapping
    public Ward create(@RequestBody Ward ward) {
        ward.setLocation("abc");
        ward.setName("aa");
        ward.setType("aa");
        return wardService.createWard(ward);
    }
}
