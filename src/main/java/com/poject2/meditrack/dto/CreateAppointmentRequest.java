package com.poject2.meditrack.dto;

import com.poject2.meditrack.model.Appointment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateAppointmentRequest {
    @NotBlank(message = "Write the DoctorID")
    private String doctorId;

    @NotBlank(message = "Write the PatientID")
    private String patientId;

    @NotNull(message = "Write appointment Date!")
    private LocalDateTime appointmentDate;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
