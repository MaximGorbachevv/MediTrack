package com.poject2.meditrack.dto;

import com.poject2.meditrack.model.Doctor;

public class DoctorResponse {
   private String fullname;
    private String cabinet;
    private String specialty;
    private String id;

    public DoctorResponse(){}
    public DoctorResponse(String fullname, String cabinet, String specialty, String id) {
        this.fullname = fullname;
        this.cabinet = cabinet;
        this.specialty = specialty;
        this.id = id;
    }

    public DoctorResponse(Doctor doctor) {
        this.id = doctor.getId();
        this.fullname = doctor.getFullname();
        this.cabinet = doctor.getCabinet();
        this.specialty = doctor.getSpecialty();

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
