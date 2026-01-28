package com.poject2.meditrack.service;


import com.poject2.meditrack.model.Appointment;
import com.poject2.meditrack.model.Doctor;
import com.poject2.meditrack.model.Patient;
import com.poject2.meditrack.repository.AppointmentRepository;
import com.poject2.meditrack.repository.DoctorRepository;
import com.poject2.meditrack.repository.PatientRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDateTime;

@DataJpaTest
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=create-drop"})
public class AppointmentServiceIntegrationTest {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
         AppointmentService service = new AppointmentService(patientRepository, doctorRepository,appointmentRepository);
    }


    @Test
    void shouldCreateAppointmentWithValidDoctorAndPatient() throws Exception {
        Doctor doctor = new Doctor();
        doctor.setId("doc1");
        doctor.setFullname("Иванов А.А.");
        doctor.setSpecialty("Терапевт");
        doctor.setCabinet("101");
        doctorRepository.save(doctor);

        Patient patient = new Patient();
        patient.setId("pat1");
        patient.setFullname("Петров И.И.");
        patient.setDateOfBirth("1990-01-01");
        patient.setContactInfo("test@example.com");
        patientRepository.save(patient);

        // Appointment saved = AppointmentService.createAppointment("doc1", "pat1", LocalDateTime.of(2025, 11, 22, 10, 0));
        Appointment saved = appointmentService.createAppointment("doc1", "pat1", LocalDateTime.of(2025, 11, 22, 10, 0));
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getDoctor().getId()).isEqualTo("doc1");
        assertThat(saved.getPatient().getId()).isEqualTo("pat1");


    }



}
