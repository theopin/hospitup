package com.org.hospitup_profile.bed;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    @GetMapping("/list")
    public List<Bed> getBeds(@RequestParam(required = false) String param) {
        return bedService.getBeds(param);
    }

    @GetMapping
    public Bed getBed(@RequestParam String id) {
        return bedService.getBed(id);
    }

    @PostMapping
    public Bed create(@RequestBody Bed bed) {
        bed.setName("aa");
        return bedService.createBed(bed);
    }
}
