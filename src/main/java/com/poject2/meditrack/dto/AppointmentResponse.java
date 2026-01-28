package com.poject2.meditrack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AppointmentResponse {
    String id;
    String doctorID;
    String patientID;
    String appointmentDate;



    public AppointmentResponse(){};

    public AppointmentResponse(String id, String doctorID, String patientID, String appointmentDate) {
        this.id=id.toString();
        this.doctorID=doctorID;
        this.patientID=patientID;
        this.appointmentDate = appointmentDate;
    }

    public String getId() {
        return id;
    }

    public String getDoctorID() {
        return doctorID;
    }


    public String getPatientID() {
        return patientID;
    }


    public String getAppointmentDate() {
        return appointmentDate;
    }

}
