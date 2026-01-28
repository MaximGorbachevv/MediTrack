package com.poject2.meditrack.controller.controller;

import com.poject2.meditrack.dto.AppointmentResponse;
import com.poject2.meditrack.dto.CreateAppointmentRequest;
import com.poject2.meditrack.exception.ResourceNotFoundExeption;
import com.poject2.meditrack.model.Appointment;
import com.poject2.meditrack.model.Doctor;
import com.poject2.meditrack.model.Patient;
import com.poject2.meditrack.repository.AppointmentRepository;
import com.poject2.meditrack.repository.DoctorRepository;
import com.poject2.meditrack.repository.PatientRepository;
import com.poject2.meditrack.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }



    @PostMapping
    public ResponseEntity <AppointmentResponse> creatAppointment(@RequestBody CreateAppointmentRequest request) {
        Appointment saved = appointmentService.createAppointment(
                request.getDoctorId(),
                request.getPatientId(),
                request.getAppointmentDate()
        );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = saved.getAppointmentDate().format(formatter);





        return ResponseEntity.ok(new AppointmentResponse(saved.getId(),request.getDoctorId(),
                request.getPatientId(),formattedDate));


    }

    }
