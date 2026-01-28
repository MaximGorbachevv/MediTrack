package com.poject2.meditrack.service;

import com.poject2.meditrack.exception.ResourceNotFoundExeption;
import com.poject2.meditrack.model.Appointment;
import com.poject2.meditrack.model.Doctor;
import com.poject2.meditrack.model.Patient;
import com.poject2.meditrack.repository.AppointmentRepository;
import com.poject2.meditrack.repository.DoctorRepository;
import com.poject2.meditrack.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {
    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    void shuldThrowExceptionWhenDoctorNotFound() {
        when(doctorRepository.findById("invalid_id")).thenReturn(Optional.empty());


        ResourceNotFoundExeption exeption = assertThrows(ResourceNotFoundExeption.class,()->
                appointmentService.createAppointment("invalid_id","path1", LocalDateTime.now()));
        assertThat(exeption.getMessage()).isEqualTo("doctor not found");

    }

    @Test
    void shuldThrowExceptionWhenDoctorAndPatientExists() {
        Doctor doctor = new Doctor();
        doctor.setId("doc1");
        doctor.setFullname("Иванов А.А.");
        doctor.setSpecialty("Терапевт");
        doctor.setCabinet("101");

        Patient patient = new Patient();
        patient.setId("pat1");
        patient.setFullname("Петров И.И.");
        patient.setDateOfBirth("1990-01-01");
        patient.setContactInfo("@exampleTest.com");

        Appointment appointment = new Appointment();
        appointment.setId("appt1");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(LocalDateTime.of(2025 ,11,22,10,0));

        when(doctorRepository.findById("doc1")).thenReturn(Optional.of(doctor));
        when(patientRepository.findById("pat1")).thenReturn(Optional.of(patient));
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentService.createAppointment("doc1", "pat1", LocalDateTime.of(2025 ,11,22,10,0));

        assertThat(result.getId()).isEqualTo("appt1");
        assertThat(result.getDoctor().getId()).isEqualTo(doctor);
        assertThat(result.getPatient().getId()).isEqualTo(patient);
        assertThat(result.getAppointmentDate()).isEqualTo(LocalDateTime.of(2025 ,11,22,10,0));

        verify(appointmentRepository).save(any(Appointment.class));





    }


}
