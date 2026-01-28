package com.poject2.meditrack.controller.controller;

import com.poject2.meditrack.dto.DoctorResponse;
import com.poject2.meditrack.dto.DoctorSummary;
import com.poject2.meditrack.model.Doctor;
import com.poject2.meditrack.repository.DoctorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private DoctorRepository doctorRepository;
    DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/summary")
    public List<DoctorSummary> getDoctorSummary() {
        return doctorRepository.findDoctorSummaries();
    }
    @GetMapping
    public List<DoctorResponse>getAllDoctors() {
        return doctorRepository.findAll().stream().map(DoctorResponse::new).toList();
    }
}
