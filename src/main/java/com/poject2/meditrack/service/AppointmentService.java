package com.poject2.meditrack.service;

import com.poject2.meditrack.dto.AppointmentResponse;
import com.poject2.meditrack.dto.CreateAppointmentRequest;
import com.poject2.meditrack.exception.ResourceNotFoundExeption;
import com.poject2.meditrack.model.Appointment;
import com.poject2.meditrack.model.Doctor;
import com.poject2.meditrack.model.Patient;
import com.poject2.meditrack.repository.AppointmentRepository;
import com.poject2.meditrack.repository.DoctorRepository;
import com.poject2.meditrack.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class AppointmentService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository=patientRepository;
        this.doctorRepository=doctorRepository;
        this.appointmentRepository=appointmentRepository;
    }
    @Transactional
    public Appointment createAppointment(String doctorId, String patientId, LocalDateTime appointmentdate ) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new ResourceNotFoundExeption("Doctor not found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundExeption("Patient not found"));
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(appointmentdate);

        return appointmentRepository.save(appointment);



    }

}
